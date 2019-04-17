<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Registrazione</title>

<#include "importCss.ftl">

</head>
<body>


<div class="w-1000 mx-auto">


    <!--<div class="alert alert-danger">Complete all fields!</div>-->


    <!-- registration form -->
    <form id="form_registrazione" action="/registrazione" method="post" class="sky-form validate boxed">
        <header class="mb-50 fs-50 fw-100 text-center">Crea Il Tuo Account</header>

        <div class="header-form"><i class="fa fa-lock"></i> INFORMAZIONI ACCESSO</div>
        <fieldset name="Accesso">
            <label class="input">
                <#if erroreEmail??>
                <div class="alert alert-danger mb-30">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Errore!</strong> Attenzione, errore email non valida.
                </div>
                </#if>
                <p><em>*</em> Indirizzo Email</p>
                <i class="ico-append giu fa fa-envelope"></i>
                <input type="text" placeholder="Indirizzo Email" name="Email" <#if email??> value="${email}" </#if>required>
                <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
            </label>

            <label class="input">
                <#if errorePassword??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> Attenzione, errore password non valida.
                    </div>
                </#if>
                <p><em>*</em> Password</p>
                <i class="ico-append giu fa fa-lock"></i>
                <input type="password" placeholder="Password" name="Password" <#if password??> value="${password}" </#if> required>
                <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                    al tuo account</b>
            </label>

            <label class="input mb-20">
                <#if errorePassword??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> Attenzione, errore password non valida.
                    </div>
                </#if>
                <p><em>*</em> Password</p>
                <i class="ico-append giu fa fa-lock"></i>
                <input type="password" placeholder="Conferma password" name="ConfermaPassword" <#if confermaPassword??> value="${confermaPassword}" </#if> required>
                <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                    al tuo account</b>
            </label>

            <label class="select">
                <#if erroreTipologia??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> Attenzione, errore campo selezionato non valido.
                    </div>
                </#if>
                <p><em>*</em> Tipologia di Account</p>
                <select id="Tipologia" class="line-height-normal" name="Tipologia" required>
                    <#if tipologia??>
                        <option value="null" disabled>Tipologia di Account</option>
                        <#if tipologia == "Tirocinante">
                            <option value="Tirocinante" selected>Tirocinante</option>
                            <option value="Ente-Azienda">Azienda</option>
                            <#else >
                                <option value="Tirocinante">Tirocinante</option>
                                <option value="Ente-Azienda" selected>Azienda</option>
                        </#if>
                        <#else>
                            <option value="null" selected disabled>Tipologia di Account</option>
                            <option value="Tirocinante">Tirocinante</option>
                            <option value="Ente-Azienda">Azienda</option>
                    </#if>
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

</body>
</html>
