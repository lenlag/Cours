package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import entity.Comm;
import entity.Post;
import entity.Posts;

public class PostService {
	private static final String KEY="__POSTS";
	
	public Posts getPosts(HttpSession session) {
		return (Posts)session.getAttribute(KEY); 
	}
	public void addPost(HttpSession session,Post post) throws Exception {
		Posts posts = getPosts(session);
		if (posts == null) {
			posts = new Posts();
			session.setAttribute(KEY, posts);
		}
		posts.add(post);
	}
	public void addComm(HttpSession session,int postIdx,Comm comm) throws Exception {
		Posts posts = getPosts(session);
		if (posts == null) {
			posts = new Posts();
			session.setAttribute(KEY, posts);
		}
		posts.addComm(postIdx, comm);
	}
	
	public List<Post> list(HttpSession session) {
		Posts posts = getPosts(session);
		if (posts == null) {
			posts = new Posts();
			session.setAttribute(KEY, posts);
		}
		return posts.getPosts();
	}
	
	public void delComm(HttpSession session,int pid,int cid) throws Exception {
		Posts posts = getPosts(session);
		if (posts == null) {
			throw new Exception("Rien en session");
		}
		posts.delCom(pid, cid);
	}
	public void delPost(HttpSession session,int pid) throws Exception {
		Posts posts = getPosts(session);
		if (posts == null) {
			throw new Exception("Rien en session");
		}
		posts.delPost(pid);
	}
}
