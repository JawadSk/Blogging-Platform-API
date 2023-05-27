# Blogging-Platform-API

## Framework and Language Used
* Spring Boot
* Java

## Dependencies

* Spring Boot Dev Tools
* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok
* Validation

## Data Flow

## Controller
### Admin

* toggleBlueTick

### Comment

* addComment
### Post

* addPost
* getAllPosts
* getLikesForPost
* updateUser
* followUser
### User

* signUp
* signIn
* ignOut
## Service
### Admin

* toggleBlueTick
### Comment

* addComment
### Follower

* saveFollower
### Following

* saveFollowing
## Repository
### Admin

* IAdminmentRepo

### Comment

* ICommentRepo

### Follower

* IFollowRepo

### Following

* IFollowingRepo

### Like

* ILikeRepo

### Post

* IPostRepo

### Token

* ITokenRepo

### User

* IUserRepo

### Model
### Admin

* adminId
* firstName
* lastName
* email
### AuthenticationToken

* tokenId
* token
* tokenCreationDate
### InstagramComment

* commentId
* commentBody
* post
* users
### InstagramFollower

* followerTableId
* users
* follower
### InstagramFollowing

* followingTableId
* users
* following
### Post

* postId
* createdDate
* postDate
* postCaption
* location
* users
### PostLike

* likeId
* post
* users
### User

* userId
* firstName
* lastName
* instagramName
* instagramBio
* password
* dOB
* email
* phoneNumber
* isBlueTick
## dto
### SignInInput

* Email
* Password
### SignInOutput

* status
* token
### SignUpOutput

* status
* message

### DataBase Used
* SQL database


## Project Summary

* The project is a basic web application built using Java and the Spring framework. It allows users to sign up, sign in, and manage their profile information. Users can also create and view posts. The application uses authentication tokens to secure users data and ensure that only authenticated users can access certain features. The API endpoints include users signup, signin, and update details, post creation and retrieval, and authentication token creation.
