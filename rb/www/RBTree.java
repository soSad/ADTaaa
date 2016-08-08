package com.rb.www;

public class RBTree <T extends Comparable<T>>{
	private RBNode<T> root;
	
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	
	public RBTree(){
		this.root = null;
	}
	
/**
 *      px                              px
 *     /                               /
 *    x                               y                
 *   /  \      --(左旋)-.          	 / \                #
 *  lx   y                          x  ry     
 *     /   \                       /  \
 *    ly   ry                     lx  ly  
 *   
*/
	private void leftRotate(RBNode<T> x){
		RBNode<T> y = x.right;
		if(y.left!=null){
			x.right = y.left;
			y.left.parent = x;
		}
		y.parent = x.parent;
		if(x.parent==null){
			this.root = y;
		}
		else{
			if(x.parent.left == x)
				x.parent.left = y;
			else
				x.parent.right = y;
		}
		y.left = x;
		x.parent = y;
	}
	
/**
 *            py                               py
 *           /                                /
 *          y                                x                  
 *         /  \      --(右旋)-.            	/  \                     #
 *        x   ry                           lx   y  
 *       / \                                   / \                   #
 *      lx  rx                                rx  ry
 */
	private void rightRotate(RBNode<T> y){
		RBNode<T> x = y.left;
		if(x.right != null){
			x.right.parent = y;
			y.left = x.right;
		}
		if(y.parent==null){
			this.root = x;
		}
		else{
			x.parent = y.parent;
			if(y == y.parent.left){
				y.parent.left = x;
			}
			else{
				y.parent.right = x;
			}
		}
		x.right = y;
		y.parent = x;
	}
	//外部接口
	public void insert(T key){
		RBNode<T> node = new RBNode<T>(key, BLACK, null, null, null);
		if(node!=null){
			insert(node);
		}
	}
	//内部接口
	private void insert(RBNode<T> node){
		int cmp;
		RBNode<T> x = this.root;
		RBNode<T> current = null;
		
		while(x!=null){
			current = x;
			cmp = node.key.compareTo(x.key);
			if(cmp < 0){
				x = x.left;
			}
			else{
				x = x.right;
			}
		}
		node.parent = current;
		if(current!=null){
			cmp = node.key.compareTo(current.key);
			if(cmp < 0){
				current.left = node;
			}
			else{
				current.right = node;
			}
		}else{
			this.root = node;
		}
		//设置节点颜色
		node.color = RED;
		//重新修正
		insertFixUp(node);
		
	}

	private void insertFixUp(RBNode<T> node) {
		RBNode<T> parent,gparent;
		
		//若父节点存在，并且父节点的颜色是红色
		while(node.parent!=null && node.color==RED){
			parent = node.parent;
			gparent = parent.parent;
			
			if(parent == gparent.left){
				//case 1 叔叔节点是红色的
				RBNode<T> uncle = gparent.right;
				if(uncle!=null && uncle.color==RED){
					uncle.color = BLACK;
					parent.color = BLACK;
					gparent.color = RED;
					node = gparent;
					continue;
				}
				
				//case 2 叔叔节点是黑色的，并且当前节点是右孩子
				if(parent.right==node){
					RBNode<T> tmp;
					leftRotate(parent);
					tmp = parent;
					parent = node;
					node = tmp;
				}
				
				//case 3 叔叔是黑色，且当前结点是左孩子
				parent.color = BLACK;
				gparent.color = RED;
				rightRotate(gparent);
				
			}
			else{
				//如果父节点是祖父节点的右孩子
				//case 1 叔叔节点是红色
				RBNode<T> uncle = gparent.left;
				if(uncle!=null && uncle.color==RED){
					uncle.color = BLACK;
					parent.color = BLACK;
					gparent.color = RED;
					node = gparent;
					continue;
				}
				//case 2 叔叔是黑色，且当前结点是左孩子
				if(parent.left==node){
					RBNode<T> tmp;
					rightRotate(parent);
					tmp = parent;
					parent = node;
					node = tmp;
					
				}
				//case 3 叔叔是黑色，且当前节点是右孩子
				parent.color = BLACK;
				gparent.color = RED;
				leftRotate(gparent);
			}
		}
		root.color = BLACK;
	}
	private void remove(RBNode<T> node){
		RBNode<T> child,parent;
		boolean color;
		if(node.left!=null && node.right!=null){
			RBNode<T> replace = node;
			//获取后继节点
			replace = replace.right;
			while(replace.left!=null){
				replace = replace.left;
			}
			if(node.parent!=null){
				if(node.parent.left == node){
					node.parent.left = replace;
				}
				else{
					node.parent.right = replace;
				}
			}
			else{
				this.root = replace;
			}
			//child是取代节点的右孩子，也是需要调整的节点
			child = replace.right;
			parent = replace.parent;
			color = replace.color;
			if(parent == node){
				parent = replace;
			}
			else{
				if(child!=null){
					child.parent = parent;
					parent.left = child;
				}
				replace.right = node.right;
				node.right.parent = replace;
			}
			replace.parent = node.parent;
			replace.color = node.color;
			replace.left = node.left;
			node.left.parent = replace;
			
			if(color == BLACK){
				removeFixUp(child,parent);
			}
			
			node = null;
			return;
		}
		if(node.left!=null){
			child = node.left;
		}
		else{
			child = node.right;
		}
		
		//保存取代节点颜色
		color = node.color;
		if(child!=null){
			child.parent = node.parent;
		}
		if(node.parent!=null){
			if(node.parent.left == node)
				node.parent.left = child;
			else
				node.parent.right = child;
		}
		else{
			this.root = child;
		}
		if(color == BLACK)
			removeFixUp(child, node.parent);
		node = null;
	}
	public void remove(T key){
		RBNode<T> node;
		if((node = search(root,key))!=null){
			remove(node);
		}
	}

	private RBNode<T> search(RBNode<T> root, T key) {
		if(root==null){
			return root;
		}
		else{
			int cmp = key.compareTo(root.key);
			if(cmp < 0){
				return search(root.left, key);
			}
			else if(cmp > 0){
				return search(root.right,key);
			}
			else
				return root;
		}
		/*非递归实现
		while(root!=null){
			int cmp = key.compareTo(root.key);
			if(cmp < 0)
				root = root.left;
			else if(cmp > 0)
				root = root.right;
			else 
				return root;
		}
		*/
	}

	private void removeFixUp(RBNode<T> node, RBNode<T> parent) {
		RBNode<T> other;
		
		while(node==null || node.color==BLACK&&node!=this.root){
			if(parent.left == node){
				other = parent.right;
				if(other.color==RED){
					//case 1 x的兄弟w是红色的
					other.color = BLACK;
					parent.color = RED;
					leftRotate(parent);
					other = parent.right;
				}
				
			}
		}
		
	}
}
