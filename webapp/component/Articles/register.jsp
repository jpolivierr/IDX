<%@ page import ="java.net.URLDecoder" %>
<article class="column-1x center-content av-padding-3x bk-alt full-height">

    <div class="container">  
        <section class="window">
            
                <%
                   Object encArray = request.getAttribute("errorMessage");

                   Object firstName = request.getAttribute("first_name") == null ? "" : request.getAttribute("first_name");

                   Object lastName = request.getAttribute("last_name") == null ? "" : request.getAttribute("last_name");

                   Object email = request.getAttribute("email") == null ? "" : request.getAttribute("email");
                   
                %>
                   <% if(encArray != null){%>

                    <% 
                         String decArray = URLDecoder.decode(encArray.toString(),"utf-8");
                         String[] messageArray = decArray.split(",");
                    %>
                     <div class="errorMessages">
                        <ul>
                            <% for(String message : messageArray){%>
                            <li><%= message %></li>
                            <% } %>
                        </ul>
                     </div>
                     <% decArray = "";%>
                   <% }%> 
            
            
            <form class="register-form" action="register" method="POST">
                <h2>Create an Account</h2>
                <p>80% of people save money by using Green Budget.</p>
                    <fieldset>
                        <label>First Name</label>
                        <input value="<%= firstName %>"  name="first_name" type="text"/>
                    </fieldset>
                    <fieldset>
                        <label>Last Name</label>
                        <input value="<%= lastName %>" name="last_name" type="text"/>
                    </fieldset>
                    <fieldset>
                        <label>Email</label>
                        <input value="<%= email %>" name="last_name" type="email"/>
                    </fieldset>
                    <fieldset>
                        <label>Password</label>
                        <input name="password" type="password"/>
                    </fieldset>
                    <fieldset>
                        <label>Repeat Password</label>
                        <input name="password2" type="password"/>
                    </fieldset>
                
                <button class="main-btn"> Get Started</button>
            </form>
            <p class="member-login-text">Already a member? <a href="#">Log in</a></p>
        </section>
        
    </div>
</article>