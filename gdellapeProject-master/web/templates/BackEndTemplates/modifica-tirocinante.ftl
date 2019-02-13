<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

  <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="admin.html">HOME DASHBOARD</a></li>
        <li><a href="/gestione-utenti"><b>GESTIONE UTENZA</b></a></li>
        <li class="active"><a href="#"><b>GESTIONE: ${tirocinante.nome} ${tirocinante.cognome}</b></a></li>
    </ol>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <div class="row">
                <a class="nav-link link-bar mt-5" href="#">Benvenuto, <b>ADMIN</b></a>
                <a class="nav-link link-bar text-center" href="#"><i class="fa fa-user-md fs-35 px-3"></i></a>
            </div>
        </li>
    </ul>

</nav>
<div class="container-fluid">
    <div class="row">
       <#include "../BackEndTemplates/sidebar.ftl">


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <div class="col">
                <form action="/modifica-tirociante" method="post">
                    <input type="hidden" name="ID" value="${tirocinante.IDTirocinante}">
                <div class="form-group">
                    <label>Email</label>
                    <input type="email" name="email" value="${user.email}">
                </div>
                <div class="form-group">
                    <label>Nuova Password</label>
                    <input type="password" name="newpassword">
                </div>
                    <div class="form-group">
                        <label>Ripeti Nuova Password </label>
                        <input type="password" name="repaetnewpassword">
                    </div>
                    <div class="form-group">
                        <label>Nome</label>
                        <input type="text" name="nome" value="${tirocinante.nome}">
                    </div>
                <div class="form-group">
                    <label>Cognome</label>
                    <input type="text" name="cognome" value="${tirocinante.cognome}">
                </div>
                <div class="form-group">
                    <label>Luogo di nascità</label>
                    <input type="text" name="luogodinascita" value="${tirocinante.luogoDiNascita}">
                </div>
                <div class="row">
                    <label>Luogo di nascità</label>
                    <input type="text" name="luogodiresidenza" value="${tirocinante.luogoDiResidenza}">
                </div>
                <div class="row">
                    <label>Procincia di Nascità</label>
                    <input type="text" name="provinciadinascita" value="${tirocinante.provinciaDiNascita}">
                </div>
                <div class="row">

                    <label>Data di Nascita ${tirocinante.dataDiNascita}</label>
                    <label>Inserire nuova data di nascita</label>
                    <input type="date" name="datadinascita" >
                </div>
                <div class="row">

                    <label>Provincia di residenza</label>
                    <input type="text" name="provinciadiresidenza" value="${tirocinante.provinciaDiResidenza}">
                </div>
                <div class="row">
                    <label>Codice Fiscale</label>
                    <input type="text" name="codicefiscale" value="${tirocinante.codiceFiscale}">
                </div>
                    <div class="row">
                        <label>Telefono</label>
                        <input type="text" name="telefono" value="${tirocinante.telefono}">
                    </div>

                <div class="row">
                    <label>Corso di Laurea</label>
                    <input type="text" name="corsodilaurea" value="${tirocinante.corsoDiLaurea}">
                </div>
                <div class="row">
                    <label>Diploma Universitario</label>
                    <input type="text" name="diplomauniversitario" value="${tirocinante.diplomaUniversitario}">
                </div>
                <div class="row">

                    <label>Laurea</label>
                    <input type="text" name="laureatouniversitario" value="${tirocinante.laureatoUniversitario}">
                </div>
                <div class="row">
                    <label>Scuola o Altro </label>
                    <input type="text" name="scuolaaltro" value="${tirocinante.scuolaAltro}">
                </div>

                <div class="row">
                    <label>Dottorato</label>
                    <input type="text" name="dottoratodiricerca" value="${tirocinante.dottoratoDiRicerca}">
                </div>
                <div class="row">
                    <label>HandiCap :  </label>
                    <input type="checkbox" name="handicap" value="1" <#if tirocinante.handicap> checked </#if>>
                </div>

                    <button type="submit" class="btn btn-primary" >Modifica</button>
                </form>

            </div>


        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->

<!-- Script page -->




</body>
</html>
