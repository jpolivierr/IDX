<%@ page import ="java.net.URLDecoder" %>
<section class="padding-xlarge bk-secondary-color full-height">

    <div class="container block-1column-center">  
        <div class="forms register-form window">
            
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
            
            <h2>Create an Account</h2>
            <p>80% of people save money by using Green Budget.</p>
            <form action="register" method="POST">
                <div class="form-input-field">
                    <input value="<%= firstName %>" type="text" name="first_name" placeholder="First Name">
                    <input value="<%= lastName %>" type="text" name="last_name" placeholder="Last Name">
                    <input value="<%= email %>" type="text" name="email" placeholder="Email Address">
                    <input type="password" name="password" placeholder="Password">
                    <input type="password" name="password2" placeholder="Repeat Password">
                </div>
                
                <button class="main-btn"> Get Started</button>
            </form>
            <p class="member-login-text">Already a member? <a href="#">Log in</a></p>
        </div>
        
    </div>
</section>