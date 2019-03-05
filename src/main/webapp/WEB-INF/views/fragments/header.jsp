<%-- 
    Document   : header.jsp
    Created on : Feb 12, 2019, 11:48:29 AM
    Author     : Johnny
--%>


<style>
    ul {
list-style-type: none;
margin: 0;
padding: 0;
overflow: hidden;
background-color: #333333;
}


li {
float: left;
}

li a {
display: block;
color: white;
text-align: center;
padding: 16px;
text-decoration: none;
}

li a:hover {
background-color: #111111;
}

.logo{
    float: left;
    width: 100px;
}
</style>

<div>
    <div class="logo">Logo</div>

    <div>
      <ul>
        <li><a href="/index">Home</a></li>
        <li><a href="/new-lit-item">Create New Item</a></li>
        <li><a href="/search">Search</a></li>
        <li><a href="/advanced-search">Advanced Search</a></li>
      </ul>
    </div>    
</div>

