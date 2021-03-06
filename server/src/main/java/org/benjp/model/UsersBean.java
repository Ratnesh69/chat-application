package org.benjp.model;

import org.benjp.utils.MessageDigester;

import java.util.List;

public class UsersBean {

  List<UserBean> users;

  public List<UserBean> getUsers() {
    return users;
  }

  public void setUsers(List<UserBean> users) {
    this.users = users;
  }

  public String usersToJSON()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    sb.append("\"users\": [");
    boolean first=true;
    for (UserBean userBean:this.getUsers()) {
      if (!first) {
        sb.append(",");
      } else {
        first=false;
      }

      sb.append(userBean.toJSON());

    }
    sb.append("],");
    sb.append("\"md5\": \"").append(MessageDigester.getHash(sb.toString())).append("\",");
    sb.append("\"timestamp\": \""+System.currentTimeMillis()+"\"");
    sb.append("}");


    return sb.toString();
  }

}
