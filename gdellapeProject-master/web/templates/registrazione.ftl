<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Registrazione</title>

<#include "importCss.ftl">
    <!-- PAGE LEVEL SCRIPTS -->
    <link href="/css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="/css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="/css/internshiptutor.css" rel="stylesheet" type="text/css">

</head>
<body>


<div class="w-1000 mx-auto">


    <!--<div class="alert alert-danger">Complete all fields!</div>-->


    <!-- registration form -->
    <form id="form_registrazione" action="/registration" method="post" class="sky-form validate boxed">
        <header class="mb-50 fs-50 fw-100 text-center">Crea Il Tuo Account</header>

        <div class="header-form"><i class="fa fa-lock"></i> INFORMAZIONI ACCESSO</div>
        <fieldset name="Accesso">
            <label class="input">
                <p><em>*</em> Indirizzo Email</p>
                <i class="ico-append giu fa fa-envelope"></i>
                <input type="text" placeholder="Indirizzo Email" name="Email" required>
                <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
            </label>

            <label class="input">
                <p><em>*</em> Password</p>
                <i class="ico-append giu fa fa-lock"></i>
                <input type="password" placeholder="Password" name="Password" required>
                <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                    al tuo account</b>
            </label>

            <label class="input mb-20">
                <p><em>*</em> Password</p>
                <i class="ico-append giu fa fa-lock"></i>
                <input type="password" placeholder="Conferma password" name="ConfermaPassword" required>
                <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                    al tuo account</b>
            </label>

            <label class="select">
                <p><em>*</em> Tipologia di Account</p>
                <select id="Tipologia" class="line-height-normal" name="Tipologia" required>
                    <option value="0" selected disabled>Tipologia di Account</option>
                    <option value="Tirocinante">Tirocinante</option>
                    <option value="Ente-Azienda">Azienda</option>
                </select>
                <i></i>
            </label>
        </fieldset>


        <footer>
            <button type="submit" form="form_registrazione" class="btn btn-success btn-lg pull-right float-right"><i
                    class="fa fa-check"></i> Crea il tuo Account
            </button>
            <button type="reset" form="form_registrazione" class="btn btn-red btn-lg pull-right float-left"><i
                    class="fa fa-times"></i> Annulla
            </button>
        </footer>

    </form>
    <!-- /registration form -->

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
<script src="/templates/js/internshiptutor.js"></script>

</body>
</html>
