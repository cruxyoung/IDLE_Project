package com.idle.app.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.idle.app.domain.Category;
import com.idle.app.domain.Comment;
import com.idle.app.domain.Item;
import com.idle.app.domain.User;
import com.idle.app.service.CategoryManager;
import com.idle.app.service.CommentManager;
import com.idle.app.service.ItemManager;
import com.idle.app.service.UserManager;
import com.idle.app.service.ViewRecordManager;

@Controller
@RequestMapping(value = "/item/**")
public class ItemController {

	@Resource(name = "itemManager")
	private ItemManager itemManager;
	
	@Autowired
	private UserManager userManager;
	
	@Autowired
	private CategoryManager categoryManager;
	@Autowired
	private CommentManager commentManager;
	@Autowired
	private ViewRecordManager viewRecordManager;
	

	// create
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addItem(HttpServletRequest httpServletRequest,  @RequestParam("file") MultipartFile file) {
		
		Item item = new Item();
		HttpSession session = httpServletRequest.getSession();
		User owner = userManager.getUserByUserId((Long)session.getAttribute("userId")).getData();
		if(owner!=null)
			item.setOwner(owner);
		
		Category cate = categoryManager.getCateByName(httpServletRequest.getParameter("category"));
		item.setCategory(cate);
		item.setName(httpServletRequest.getParameter("name"));
		item.setQuantity(Long.valueOf(httpServletRequest.getParameter("quantity")));
		item.setDescription(httpServletRequest.getParameter("description"));
		item.setPrice(Double.valueOf(httpServletRequest.getParameter("price")));
		item.setCreateTime(new Date());
		item.setLastEditTime(new Date());
		

		if(item.getName().length()==0) item.setName("default"+ new Date().toString());
		String name = item.getName();
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				
				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator );
				if (!dir.exists())
					dir.mkdirs();
				
				
				String fileName2 = null;
			    fileName2 = httpServletRequest.getSession().getServletContext().getRealPath("/");


			    String saveDirectory = dir+"\\webapps\\IDLE\\resources\\images\\";
					
				// Create the file on server
				File serverFile = new File(saveDirectory+name+".png");

				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				item.setPhoto("/app/resources/images/"+name+".png");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("You failed to upload " + name
					+ " because the file was empty.");
		}
		
		
		
		this.itemManager.addItem(item);
//		redirect to main page(to be implemented)
		return "redirect:/";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddItem(Model model, HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		Long userId = (Long) session.getAttribute("userId");
		if(userId==null) {
			try {
				response.sendRedirect("http://localhost:8080/app/user/login?error=notlogin");
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		List<Category> cates = categoryManager.getCategories();
		model.addAttribute("cates",cates);
		return "addItem";
	}

	// delete
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String deleteItem(@PathVariable("id") Long id) {
		this.itemManager.deleteItem(id);
		return "delete ok";

	}

	// read
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public String getItem(@PathVariable("id") Long id, HttpSession session ,Model model ) {
		Map<String, String> res = new HashMap();
		Item item = this.itemManager.getItemById(id);
		// res.put("id", new Long(itm.getId()).toString());
		// res.put("name", itm.getName());
		if(item!=null)
			session.setAttribute("itemId", id);
		Long userId = (Long)session.getAttribute("userId");
		if(userId!=null) {
			this.viewRecordManager.addRecord(item, this.userManager.getUserByUserId(userId).getData());
		}
		model.addAttribute("item", item);
		List<Comment> comments = commentManager.getCommentsByItem(item).getData();
		model.addAttribute("comments", comments);
		if (item == null)
			System.out.println("get no itm");
		return "itemDisplay";

	}
	
	@RequestMapping(value="/comment/add", method= RequestMethod.POST)
	public String addComment(HttpServletRequest httpServletRequest,HttpSession session) {
		Long itemId = (Long)session.getAttribute("itemId");
		Item item = itemManager.getItemById(itemId);
		String content = httpServletRequest.getParameter("content");
		User user = userManager.getUserByUserId((Long)session.getAttribute("userId")).getData();
		commentManager.addComments(content, item, user);
		return "redirect:/item/get/"+itemId.toString();
		
	}
	@RequestMapping(value="/get/comment/delete/{id}", method= RequestMethod.GET)
	public String deleteComment(@PathVariable("id") Long id, HttpSession session,HttpServletResponse response) {
		Long userId = (Long) session.getAttribute("userId");
		Long itemId = (Long)session.getAttribute("itemId");
		Comment com = commentManager.getCommentsById(id).getData();
		if(com.getUser().getUserId().equals(userId)) {
			commentManager.deleteComment(id);
			
			return "redirect:/item/get/"+itemId.toString();
		}else {
			try {
				response.sendRedirect("http://localhost:8080/app/item/get/"+itemId.toString()+"?error=notAuthorized");
				return null;
			}catch(IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		
	}
	
	
	
	

}
