package com.springboot.blog.utils;

public class AppConstant {
        private AppConstant() {
        }
        // API Routes Path
        public static final String BASE_API_ROUTES="/api/v1";
        // Post API
        public static final String POST_POSTMAPPING="/createPost";
        public static final String POST_GETMAPPING="/getAllPosts";
        public static final String POST_GETBYID="/getById/{id}";
        public static final String POST_UPDATEBYID="/updatePostById/{id}";
        public static final String POST_DELETEMAPPING="/deletePostById/{id}";
        // Comment API
        public static final String COMMENT_POSTMAPPING="/createComment/posts/{postId}/comments";
        public static final String COMMENT_GETALLCOMMENTS="/getAllComments/posts/{postId}/comments";
        public static final String COMMENT_GETCOMMNENTBYID="/getCommentById/posts/{postId}/comments/{commentId}";
        public static  final String COMMENT_UPDATE_COMMENT="/updateComment/posts/{postId}/comments/{commentId}";
        public static final String COMMENT_DELETE_COMMENT="/deleteComment/posts/{postId}/comments/{commentId}";

        // Status
        public static final String STATUS_SUCCESS ="Success";
        public static final String STATUS_FAILURE="Failure";
        // User Details
        public static final String AKSHAY="akshay";
        public static final String ADMIN="admin";
        public static final String ROLE_USER="USER";
        public static final String ROLE_ADMIN="ADMIN";

        // Pagination & Sorting
        public static final String PAGE_NUMBER="pageNo";
        public static final String DEFAULT_PAGE_NUMBER="0";
        public static final String PAGE_SIZE="pageSize";
        public static final String DEFAULT_PAGE_SIZE="10";
        public static final String SORT_BY="sortBy";
        public static final String DEFAULT_SORT_BY="id";
        public static final String SORT_DIRECTION= "sortDir";
        public static final String DEFAULT_SORT_DIRECTION="asc";

        // Message
        public static final String COMMENT_DOES_NOT_BELONG_TO_POST="Comment does not belong to post";
        public static final String COMMENT_DELETED_SUCCESSFULLY="Comment deleted  successfully";
        public static final String POST_DELETED_SUCCESSFULLY="Post entity deleted successfully";
        public static final String POSTID= "postId";
        public static final String COMMENT_ID = "commentId";

        // Field
        //Comment
        public static final  String ID ="id";
        public static final String COMMENT = "comments";
        public static final String NAME= "name";
        public static final String EMAIL ="email";
        public static final String BODY = "body";
        public static final String POST_ID = "post_id";
        public static final String POST = "post";
        //Post
        public static final String POSTS = "posts";
        public static final String TITLE="title";
        public static final String DESCRIPTION="description";
        public static final String CONTENT="content";
        // User
        public static final  String USER="users";
        public static final String USERNAME="username";
        public static final String PASSWORD="password";
        //Role
        public static final String ROLE="roles";


        //Error Message
        public static final String ERROR_MESSAGE_TITLE= "Post title should have at least 2 characters";
        public static final String ERROR_MESSAGE_DESCRIPTION= "Post description have at least 10 characters";
        public static final String ERROR_MESSAGE_NAME= "Name should not be null or empty";
        public static final String ERROR_MESSAGE_EMAIL= "Email should not  be null or empty";
        public static final String ERROR_MESSAGE_BODY = "comment body must be minimum 10 characters";





    }


