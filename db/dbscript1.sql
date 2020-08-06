-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: forumdb
-- ------------------------------------------------------
-- Server version	8.0.19



--
-- Table structure for table `message`
--


--
-- Dumping data for table `message`
--
use forumdb;

INSERT INTO `message` (`id`, `theme_id`, `user_id`, `date`, `text`, `replied_message_id`) VALUES (1,1,1,'2020-07-03 18:56:40','бля ребят почему не пишите(',NULL),(2,1,1,'2020-07-09 21:25:10','все, ненадо,проблема решена',1);

INSERT INTO `role` (`id`, `name`) VALUES (1,'ROLE_GUEST'),(2,'ROLE_USER'),(3,'ROLE_ADMIN');

INSERT INTO `tag` (`id`, `name`) VALUES (1,'#programming'),(2,'#python'),(6,'Anime'),(13,'anyshit'),(7,'hell_kitchen'),(11,'lifehacks'),(9,'movies'),(12,'music'),(3,'newTag'),(8,'pizza'),(4,'Programming'),(10,'school'),(5,'SomeTag');

INSERT INTO `tagged` (`tag_id`, `theme_id`) VALUES (4,1);

INSERT INTO `theme` (`id`, `user_id`, `title`, `description`, `date`, `state`) VALUES (1,1,'python','dva pythona','2020-07-13 06:55:22',0);

INSERT INTO `user` (`id`, `login`, `password`, `email`, `picture`, `is_non_locked`) VALUES (1,'whatisluve','$2a$10$TzLN1FmM5rN9DIaSqoqV9eoS7N.R8R.J/JG5hU1InRyvf4BddaIYC','1985-589@mail.ru',NULL,_binary ''),(4,'vandlvlad','$2a$10$NsGCsTnx9ue1jf/f68mj.O3aIs3fGLP.ZzaLtEDTg.s0WCZPIDwEG','vandl3511@gmail.com',NULL,_binary '\0'),(6,'228228','$2a$10$Me1NGZLpYCGgdomtaLjnt.U6rDb1iU7Rzr2BzV.84J1aml9Gi7/c.','email@gmail.com',NULL,_binary ''),(7,'popazhopa','$2a$10$OSQ.TtZ891sNdbSaz4b8LOMGPYuNYNCqxNIOXr07MVPN6Gv8gWk2y','emailornotemail@gmail.com',NULL,_binary '');

INSERT INTO `user_downvoted_messages` (`downvotes_id`, `downvoted_messages_id`, `user_id`) VALUES (7,1,43);

INSERT INTO `user_roles` (`user_id`, `roles_id`) VALUES (1,1),(1,2),(6,2),(7,2);


--
