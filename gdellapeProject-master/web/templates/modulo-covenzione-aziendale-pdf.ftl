<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modulo Convenzione</title>
    <#include "importCss.ftl">

</head>
<body class="smoothscroll enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130 "
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1 class="uppercase">Modulo Convenzione</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il mio account</a></li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="border bg-white p-30 radius-5">
            <#--<h1 class="mb-30 fs-50 fw-100 text-center border-bottom">MODULO CONVENZIONE</h1>-->
            <embed src="/pdfview/" type="application/pdf" style="height: -webkit-fill-available; width: -webkit-fill-available;">
        </div>
    </section>

    <#include "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">

</body>
</html>
