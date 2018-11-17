<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Richiesta Reset password</title>

    <#include "importCss.ftl">
</head>
<body>


<div class="w-800 mx-auto mt-50">

 <#if errore??>
 <#list errore as errore>
 <#switch errore>

     <#case 1>
 <div class="alert alert-danger">
     <strong>Errore! Email non trovata.</strong><br>Riprova ad inserire di nuovo la email corretta, se persiste l&apos;errore conttatta un aministratore.
 </div>
     <#break>

     <#case 2>
 <div class="alert alert-danger">
     <strong>Errore! Chiave di sicurezza errata</strong><br>Riprova la procedura, se persiste l&apos;errore conttatta un aministratore.
 </div>
     <#break>
 </#switch>
 </#list>
 </#if>
    <!-- reset form -->
    <form id="form_ric_reset_pwd" action="/reset" method="post" class="sky-form  boxed">
        <header class="mb-50 fs-50 fw-100 text-center">Richiesta Reset Password</header>

        <div class="header-form"><i class="fa fa-lock"></i> INFORMAZIONI ACCESSO</div>
        <fieldset name="Accesso">
            <label class="input">
                <p><em>*</em> Indirizzo Email</p>
                <i class="ico-append giu fa fa-envelope"></i>
                <input type="text" placeholder="Indirizzo Email" name="Email" required>
                <b class="tooltip tooltip-bottom-right">Necessario per inviare l'email per il reset della password</b>
            </label>
        </fieldset>

        <footer>
            <button type="submit" form="form_ric_reset_pwd" class="btn btn-success btn-lg pull-right float-right"><i
                    class="fa fa-check"></i> Invia email per il reset della password
            </button>
            <button type="reset" form="form_ric_reset_pwd" class="btn btn-red btn-lg pull-right float-left"><i
                    class="fa fa-times"></i> Annulla
            </button>
        </footer>

    </form>
    <!-- /reset form -->

</div>
<#include "importScript.ftl">

</body>
</html>