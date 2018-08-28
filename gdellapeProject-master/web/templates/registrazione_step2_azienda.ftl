<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registrazione - Parte 2</title>

    <#include "importCss.ftl">
    <!-- PAGE LEVEL SCRIPTS -->
    <link href="/templates/css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="/templates/css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="/templates/css/internshiptutor.css" rel="stylesheet" type="text/css">
</head>
<body class="smoothscroll enable-animation">
<div class="w-1000 mx-auto">
    <form id="form_registrazione" action="/registration" method="post" class="sky-form .validate boxed"
          novalidate="novalidate">

        <header class="mb-50 fs-50 fw-100 text-center">Crea Il Tuo Account</header>

        <div id="Ente-Azienda" class="header-form mb-30"><i class="fa fa-balance-scale"></i>&nbsp; INFORMAZIONI ENTE /
            AZIENDA
        </div>
        <fieldset name="step-1" class="d-none">
            <input type="hidden" name="Email" value=${Email}>
            <input type="password" class="d-none" name="Password" value=${Password}>
            <input type="hidden" name="Tipologia" value="Ente-Azienda">
        </fieldset>
        <fieldset name="Ente-Azienda">

            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>L&rsquo;Ente/Azienda:&nbsp;</h4>
                </div>
                <div class="col">
                    <label class="input">
                        <input type="text" placeholder="Nome Ente / Azienda" name="NomeAzienda" required>
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>Con sede legale in (indirizzo): &nbsp;</h4>
                </div>
                <div class="col">
                    <label class="input">
                        <input type="text" placeholder="Indirizzo sede legale" name="SedeLegale" required>
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>Codice Fiscale (o Partita IVA): &nbsp;</h4>
                </div>
                <div class="col">
                    <label class="input">
                        <input type="text" placeholder="Codice Fiscale o Partita IVA" name="PartitaIVA" required>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="col-auto mt-6">
                    <h4>Rappresentato da: &nbsp;</h4>
                </div>
                <div class="col">
                    <div class="row">
                        <div class="col-md-6">
                            <label class="input">
                                <input type="text" placeholder="Nome Rappresentante Aziendale" name="NomeRappresentante"
                                       required>
                            </label>
                        </div>
                        <div class="col-md-6">
                            <label class="input">
                                <input type="text" placeholder="Cognome Rappresentante Aziendale"
                                       name="CognomeRappresentante" required>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>Nominativo responsabile dei tirocini: &nbsp;</h4>
                </div>
                <div class="col">
                    <div class="row">
                        <div class="col-md-6">
                            <label class="input">
                                <input type="text" placeholder="Nome Responsabile" name="NomeResponsabile" required>
                            </label>
                        </div>
                        <div class="col-md-6">
                            <label class="input">
                                <input type="text" placeholder="Cognome Responsabile" name="CognomeResponsabile"
                                       required>
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>Numero di telefono del responsabile dei tirocini: &nbsp;</h4>
                </div>
                <div class="col">
                    <label class="input">
                        <input type="tel" placeholder="Numero di telefono" name="NumeroTelefonoResponsabile"
                               required>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>Indirizzo email del responsabile dei tirocini: &nbsp;</h4>
                </div>
                <div class="col-md-12 col-lg">
                    <label class="input">
                        <input type="email" placeholder="Email responsabile" name="EmailResponsabile" required>
                    </label>
                </div>
            </div>
        </fieldset>
        <footer>
            <button type="submit" form="form_registrazione" class="btn btn-success btn-lg pull-right float-right"><i
                    class="fa fa-check"></i> Crea il tuo Account
            </button>
            <a href="/registration">
            <button type="reset" form="form_registrazione" class="btn btn-red btn-lg pull-right float-left"><i
                    class="fa fa-times"></i> Annulla
            </button>
            </a>
        </footer>
    </form>
</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">

</body>
</html>
