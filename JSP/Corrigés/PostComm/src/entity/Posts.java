package entity;

import java.util.ArrayList;
import java.util.List;

public class Posts {
	List<Post> posts = new ArrayList<Post>();
	int lastId = 0;
	
	private Post getPostById(int idx) {
		for (Post p : posts) {
			if (p.getId() == idx) {
				return p;
			}
		}
		return null;
	}
	private Comm getComById(Post post,int idx) {
		for (Comm c : post.getComms()) {
			if (c.getId() == idx) {
				return c;
			}
		}
		return null;
	}
	public Posts() {
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public void add(Post post) {
		int i = ++lastId;
		post.setId(i);
		posts.add(post);
	}
	public void addComm(int postIdx,Comm com) throws Exception {
		Post post = getPostById(postIdx);
		if (post == null) {
			throw new Exception("Pas de post pour id = "+postIdx);
		}
		int i = post.getLastCommId()+1;
		post.setLastCommId(i);
		com.setId((post.getId()*1000) + i);
		post.getComms().add(com);
	}
	public void delCom(int postIdx,int commIdx) throws Exception {
		Post post = getPostById(postIdx);
		if (post == null) {
			throw new Exception("Pas de post pour id = "+postIdx);
		}
		Comm comm = getComById(post, commIdx);
		if (comm == null) {
			throw new Exception("Pas de com pour id = "+commIdx);
		}
		post.getComms().remove(comm);
	}
	public void delPost(int postIdx) throws Exception {
		Post post = getPostById(postIdx);
		if (post == null) {
			throw new Exception("Pas de post pour id = "+postIdx);
		}
		posts.remove(post);
	}
}
