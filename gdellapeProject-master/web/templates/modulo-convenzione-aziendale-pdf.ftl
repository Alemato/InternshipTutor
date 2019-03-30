<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modulo Convenzione</title>

    <#include "importCss.ftl">
    <!-- PAGE LEVEL SCRIPTS -->
    <link href="/css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="/css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="/css/internshiptutor.css" rel="stylesheet" type="text/css">
    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">
</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130 d-print-none"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1 class="uppercase">Modulo termine Progetto Formativo e Di Orientamento</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il mio account</a></li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <embed src="${pdfurl}" type="application/pdf">
        </div>
    </section>

<#include  "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">


</body>
</html>
