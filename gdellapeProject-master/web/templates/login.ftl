<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

  <#include "importCss.ftl">

</head>
<body>

<div class="w-550 mx-auto mt-50">
    <form id="form_registrazione" action="/login" method="post" class="sky-form .validate boxed"
          novalidate="novalidate">
        <header class="mb-50 fs-50 fw-100 text-center">Effettua il login</header>
        <div class="header-form"><i class="fa fa-lock"></i> INFORMAZIONI ACCESSO</div>
        <fieldset name="Accesso" class="mb-20">
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

            <label class="checkbox fs-14">
                <input type="checkbox" name="ricordami" value="1">
                <i></i>Ricordami
                <a class="float-right fw-100" href="/reset"> Ho dimenticato la password ?</a>
            </label>
        </fieldset>

        <footer class="bt-0">
            <button type="submit" form="form_registrazione"  class="btn btn-success btn-lg pull-right float-right"><i
                    class="fa fa-check"></i> Accedi
            </button>
            <button type="reset" form="form_registrazione" class="btn btn-red btn-lg pull-right float-left"><i
                    class="fa fa-times"></i> Annulla
            </button>
        </footer>

        <h4 class="text-center mt-15 mb-25">Non hai un account? <a href="/registrazione">Registrati subito!</a></h4>
    </form>
</div>

<#include "importScript.ftl">
</body>
</html>