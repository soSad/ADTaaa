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
 *   /  \      --(����)-.          	 / \                #
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
 *         /  \      --(����)-.            	/  \                     #
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
	//�ⲿ�ӿ�
	public void insert(T key){
		RBNode<T> node = new RBNode<T>(key, BLACK, null, null, null);
		if(node!=null){
			insert(node);
		}
	}
	//�ڲ��ӿ�
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
		//���ýڵ���ɫ
		node.color = RED;
		//��������
		insertFixUp(node);
		
	}

	private void insertFixUp(RBNode<T> node) {
		RBNode<T> parent,gparent;
		
		//�����ڵ���ڣ����Ҹ��ڵ����ɫ�Ǻ�ɫ
		while(node.parent!=null && node.color==RED){
			parent = node.parent;
			gparent = parent.parent;
			
			if(parent == gparent.left){
				//case 1 ����ڵ��Ǻ�ɫ��
				RBNode<T> uncle = gparent.right;
				if(uncle!=null && uncle.color==RED){
					uncle.color = BLACK;
					parent.color = BLACK;
					gparent.color = RED;
					node = gparent;
					continue;
				}
				
				//case 2 ����ڵ��Ǻ�ɫ�ģ����ҵ�ǰ�ڵ����Һ���
				if(parent.right==node){
					RBNode<T> tmp;
					leftRotate(parent);
					tmp = parent;
					parent = node;
					node = tmp;
				}
				
				//case 3 �����Ǻ�ɫ���ҵ�ǰ���������
				parent.color = BLACK;
				gparent.color = RED;
				rightRotate(gparent);
				
			}
			else{
				//������ڵ����游�ڵ���Һ���
				//case 1 ����ڵ��Ǻ�ɫ
				RBNode<T> uncle = gparent.left;
				if(uncle!=null && uncle.color==RED){
					uncle.color = BLACK;
					parent.color = BLACK;
					gparent.color = RED;
					node = gparent;
					continue;
				}
				//case 2 �����Ǻ�ɫ���ҵ�ǰ���������
				if(parent.left==node){
					RBNode<T> tmp;
					rightRotate(parent);
					tmp = parent;
					parent = node;
					node = tmp;
					
				}
				//case 3 �����Ǻ�ɫ���ҵ�ǰ�ڵ����Һ���
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
			//��ȡ��̽ڵ�
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
			//child��ȡ���ڵ���Һ��ӣ�Ҳ����Ҫ�����Ľڵ�
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
		
		//����ȡ���ڵ���ɫ
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
		/*�ǵݹ�ʵ��
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
					//case 1 x���ֵ�w�Ǻ�ɫ��
					other.color = BLACK;
					parent.color = RED;
					leftRotate(parent);
					other = parent.right;
				}
				
			}
		}
		
	}
}
