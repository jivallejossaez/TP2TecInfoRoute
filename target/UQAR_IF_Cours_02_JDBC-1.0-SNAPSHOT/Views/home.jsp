<%-- 
    Document   : home
    Created on : 12 nov. 2019, 17:05:03
    Author     : yacin
--%>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Accueil"/>
</jsp:include>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Bienvenue <b><%= session.getAttribute("fullname")%></b></h1>
        <p class="lead">Ceci est la page principale.</p>

        <h2>Mettre à jour les informations</h2>
        <form action="${pageContext.request.contextPath}/UpdateInfo" method="post">
            <div class="form-group row">
                <div class="col">
                    <input required type="password" class="form-control" name="new_data_password" placeholder="Entrez votre nouveau mot de passe">
                </div>
                <div class="col">
                    <button class="btn btn-primary float-right" type="submit" style="width: 200px;">Modifier mot de passe</button>
                </div>
            </div>  
        </form>
            
        <% if(request.getAttribute("erreur") == "false"){ %>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <b>Info :</b> le mot de passe a été mis à jour !
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% } else if(request.getAttribute("erreur") == "true"){ %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <b>Erreur :</b> le mot de passe n'a pas été mis à jour !
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        <% } %>
        
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/Deconnecter">Se Déconnecter</a>
    </div>
    
    <% 
        if(session.getAttribute("fullname") == null)
            response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
    %>
</div>

<%@ include file="footer.jsp"%>
