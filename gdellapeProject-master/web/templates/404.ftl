<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pagina Non Trovata</title>
  <#include "importCss.ftl">

    <!-- PAGE LEVEL SCRIPTS -->
    <link href="css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="css/internshiptutor.css" rel="stylesheet" type="text/css">

</head>
<body class="smoothscroll enable-animation">

<!-- wrapper -->
<div id="wrapper">
  <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('http://localhost:8080/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>ERRORE PAGINA NON TROVATA</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container">
            <h1 class="error-404">404</h1>
            <div class="col-8 mx-auto">
            <h3 class="mb-10 col-auto">Siamo spiacenti, la pagina richiesta non &egrave; stata trovata!</h3>
            <a class="fs-20 font-lato" href="/home"><i class="glyphicon glyphicon-menu-left mr-10 fs-16"></i> Torna alla  Homepage adesso!</a>
            </div>
        </div>
    </section>
    <!-- /SECTION CENTER -->

    <#include "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">


</body>
</html>