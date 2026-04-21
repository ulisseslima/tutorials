@org.hibernate.annotations.NamedEntityGraph(name = "post-with-comment-users", graph = "Post: subject, user, comments(user)")
package com.baeldung.hibernate.entitygraph.model;
