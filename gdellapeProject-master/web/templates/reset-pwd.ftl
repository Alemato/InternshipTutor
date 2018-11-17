<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Reset password</title>
    <#include "importCss.ftl">
</head>
<body>
 <#if errore??>
     <#list errore as errore>
         <#switch errore>

             <#case 1>
 <div class="alert alert-danger">
     <strong>Errore! Le password non coincidono.</strong><br>Riprova ad inserire di nuovo la password, ricordati che le password devo essere uguali. Se l&apos;errore persiste conttatta un aministratore.
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
<div class="w-550 mx-auto mt-50">
    <form id="form_reset_password" action="/reset" method="post" class="sky-form .validate boxed"
          novalidate="novalidate">
        <header class="mb-50 fs-50 fw-100 text-center">Reset della Password</header>
        <div class="header-form"><i class="fa fa-lock"></i> INFORMAZIONI ACCESSO</div>
        <fieldset name="Accesso" class="mb-20">
            <input type="hidden" name="Token" value="${token}">
            <label class="input">
                <p><em>*</em> Nuova Password</p>
                <i class="ico-append giu fa fa-lock"></i>
                <input type="password" placeholder="Password" name="New_password" required>
                <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                    al tuo account</b>
            </label>
            <label class="input">
                <p><em>*</em> Ripeti Password</p>
                <i class="ico-append giu fa fa-lock"></i>
                <input type="password" placeholder="Password" name="Rep_password" required>
                <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                    al tuo account</b>
            </label>
        </fieldset>

        <footer class="bt-0">
            <button type="submit" form="form_reset_password" class="btn btn-success btn-lg pull-right float-right"><i
                    class="fa fa-check"></i> Aggiorna Password
            </button>
            <button type="reset" form="form_reset_password" class="btn btn-red btn-lg pull-right float-left"><i
                    class="fa fa-times"></i> Annulla
            </button>
        </footer>
    </form>
</div>
<#include "importScript.ftl">
</body>
</html>