package com.cts.bloggingwebsite.app;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cts.bloggingwebsite.dao.AttachmentDao;
import com.cts.bloggingwebsite.dao.BlogPostDao;
import com.cts.bloggingwebsite.dao.CategoryDao;
import com.cts.bloggingwebsite.dao.CommentDao;
import com.cts.bloggingwebsite.dao.UserDao;
import com.cts.bloggingwebsite.entities.Attachment;
import com.cts.bloggingwebsite.entities.BlogPost;
import com.cts.bloggingwebsite.entities.Category;
import com.cts.bloggingwebsite.entities.Comment;
import com.cts.bloggingwebsite.entities.User;
import com.cts.bloggingwebsite.serviceDao.AttachmentService;


public class App 
{
	private static final Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        
        
        boolean isRunning = true;
        
        do {
        	
        	System.out.println();
        	System.out.println("Welcome to Blogger");
        	System.out.println("Now, Post your blog easily");
        	System.out.println();
        	
        	System.out.println("1. Login");
        	System.out.println("2. Register");
        	System.out.println("99. Close Application");
        	
        	System.out.println("Enter your choice: ");
        	int choice = sc.nextInt();
        	
        	switch (choice) {
			case 1:
				handleLogin(context);
				break;
			case 2:
				handleRegister(context);
				break;
			
			case 99:
				System.out.println("Thanks for using....");
				isRunning = false;
				break;

			default:
				System.out.println("Please enter valid choice only");
			}
     	
        }
        while(isRunning);

    }
		
    private static void handleLogin( ApplicationContext context ) {
		
    	System.out.println("Enter Email: ");
    	String email = sc.next();
    	
    	System.out.println("Enter Password: ");
    	String password = sc.next();
    	
    	boolean isSuccess = context.getBean(UserDao.class).login(email, password);
    	
    	if(isSuccess) {
    		
    		boolean isRunning = true;
    		
    		do {
    			
    			System.out.println("Choose following option: ");
    			System.out.println("1. Post Blog");
    			System.out.println("2. Add comment");
    			System.out.println("3.Display all users");
    			System.out.println("99. Log out");
    			System.out.println("101. Exit Application");
    			
    			System.out.println("Enter your choice");
    			int choice = sc.nextInt();
    			
    			switch(choice) {
    			case 1:
    				handlePostBlog(context);
    				break;
    			case 2:
    				handleComment(context);
    				break;
    			case 3:
    				displayAllUsers(context);
    				break;
    			case 99:
    				System.out.println("Logged out successfully");
    				isRunning=false;
    				break;
    			case 101:
    				System.out.println("Thanks for using application");
    				isRunning=false;
    				break;
				default:
					System.out.println("Please enter a valid choice only ");
    			}	
    			
    		}while(isRunning);
    	}
    	else {
    		System.out.println();
    		System.out.println("====================== Failure ========================");
    		System.out.println("Authentication Failed");
    		System.out.println();
    		
    		
    	}
    	
		
	}
    private static void displayAllUsers(ApplicationContext context) {
		UserDao userDao=context.getBean(UserDao.class);
		List<User> list=userDao.getAllUsers();
		for(User element : list)
		{
			System.out.println(element.getUser_id()+"  "+element.getUsername()+"  "+element.getEmail());
		}
		
		
	}

	private static void handleComment(ApplicationContext context) {
    	CommentDao commentDao = context.getBean(CommentDao.class);
        Comment comment = new Comment();

        System.out.println("Enter the post ID to add a comment to: ");
        int post_id = sc.nextInt();
        comment.setPost_id(post_id);

        System.out.println("Enter your name: ");
        String commenter_name = sc.nextLine();
        comment.setCommenter_name(commenter_name);

        System.out.println("Enter your comment: ");
        String comment_content = sc.nextLine(); // You can use sc.nextLine() if the comment can have multiple words
        comment.setComment_content(comment_content);

        commentDao.addComment(comment);
        System.out.println("Comment added successfully.");
			
	}

	private static void handlePostBlog(ApplicationContext context) {
        BlogPost blogPost = new BlogPost();

        System.out.println("Enter title of your vlog: ");
        sc.nextLine(); // Consume the newline character
        String title = sc.nextLine();
        blogPost.setTitle(title);

        System.out.println("Write your Blog:");
        String content = sc.nextLine();
        blogPost.setContent(content);

//        System.out.println("Enter publication date (DD/MM/YYYY): ");
//        String publication_date = sc.next();
        blogPost.setPublication_date(Date.valueOf(LocalDate.now()).toString());

        System.out.println("Enter your blog Category id from the below categories: ");
        displayBlogCategories(context);
        
        int category_id = sc.nextInt();
        blogPost.setCategory_id(category_id);

        System.out.println("Enter your user_id:");
        int user_id = sc.nextInt();
        blogPost.setUser_id(user_id);

        BlogPostDao blogPostDao = context.getBean(BlogPostDao.class);

        boolean response = blogPostDao.addBlogPost(blogPost);

        if (response) {
            System.out.println("Blog uploaded successfully.");
            System.out.println("");
        } else {
            System.out.println("An error occurred while uploading the Blog");
        }
        System.out.println("Do you want to also add attachment: ");
    	String attachmentChoice=sc.next();
    	
    	if("yes".equalsIgnoreCase(attachmentChoice))
    	{
    		handleAttachments(context,blogPost.getPost_id());
    	}
    	
    }
    
    private static void displayBlogCategories(ApplicationContext context)
    {
    	System.out.println("Here are the Blog Categories");
    	CategoryDao categoryDao=context.getBean(CategoryDao.class);
    	List<Category> categoryList=categoryDao.getAllCategories();
    	for(Category item : categoryList)
    	{
    		System.out.println(item.getCategory_id()+"  "+item.getCategory_name());
    	}
    	
    	
    }

    private static void handleAttachments(ApplicationContext context,int post_id)
    {
    	AttachmentDao attachmentDao=context.getBean(AttachmentDao.class);
    	
    	boolean addMoreAttachments=true;
    	
    	while(addMoreAttachments)
    	{
    		System.out.println("Enter file path for attachment: ");
    		String filePath=sc.next();
    		
    		System.out.println("Enter file type for attachment: ");
    		String fileType=sc.next();
    		
    		Attachment attachment=new Attachment();
    		attachment.setPost_id(post_id);
    		attachment.setFile_path(filePath);
    		attachment.setFile_type(fileType);
    		
    		attachmentDao.addAttachment(attachment);
    		System.out.println("Attachment added successfully.");
    		System.out.println("Do you want to add more attachments? (yes/no)");
    		String moreAttachmentsChoice=sc.next();
    		
    		addMoreAttachments="yes".equalsIgnoreCase(moreAttachmentsChoice);
    		
    		
    	}
    }
    
	private static void handleRegister(ApplicationContext context) {
			
			User user = new User();
			
			System.out.println("Enter Name: " );
			String name = sc.next();
			user.setUsername(name);
	
			System.out.println("Enter Email: ");
			String email = sc.next();
			user.setEmail(email);
			
			System.out.println("Enter Password: ");
			String password = sc.next();
			user.setPassword(password);
			
			UserDao userDao = context.getBean(UserDao.class);
			
			
			boolean response = userDao.addUser(user);
			
			if(response) {
				System.out.println("User registered successfully.");
				System.out.println("");
			}else {
				System.out.println("An error occurred while registering");
			}
		
			
		}


}
