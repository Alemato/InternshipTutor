<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Registrazione - Parte 2</title>

    <#include "importCss.ftl">

</head>
<body class=" enable-animation">
<div class="w-1000 mx-auto">
    <form id="form_registrazione" action="/registrazione" method="post" class="sky-form boxed">

        <header class="mb-50 fs-50 fw-100 text-center">Crea Il Tuo Account</header>

        <div id="Ente-Azienda" class="header-form mb-30"><i class="fa fa-balance-scale"></i>&nbsp; INFORMAZIONI ENTE /
            AZIENDA
        </div>
        <fieldset name="step-1" class="d-none">
            <input type="hidden" name="Email" value=${email}>
            <input type="password" class="d-none" name="Password" value=${password}>
            <input type="password" class="d-none" name="ConfermaPassword" value=${confermaPassword}>
            <input type="hidden" name="Tipologia" value="Ente-Azienda">
        </fieldset>
        <fieldset name="Ente-Azienda">

            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>L&rsquo;Ente/Azienda:&nbsp;</h4>
                </div>
                <div class="col">
                    <#if erroreNomeAzineda??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> <#if erroreNomeAzineda??>${erroreNomeAzineda}</#if>
                    </div>
                </#if>
                    <label class="input">
                        <input type="text" <#if erroreNomeAzineda??> class="error" </#if> placeholder="Nome Ente / Azienda" name="NomeAzienda" <#if nomeAzineda??> value="${nomeAzineda}" </#if>required>
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>Con sede legale in (indirizzo): &nbsp;</h4>
                </div>
                <div class="col">
                    <#if erroreSedeLegale??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> <#if erroreSedeLegale??> ${erroreSedeLegale} </#if>
                    </div>
                </#if>
                    <label class="input">
                        <input type="text" <#if erroreSedeLegale??> class="error" </#if> placeholder="Indirizzo sede legale" name="SedeLegale" <#if sedeLegale??> value="${sedeLegale}" </#if> required>
                    </label>
                </div>
            </div>

            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>Codice Fiscale (o Partita IVA): &nbsp;</h4>
                </div>
                <div class="col">
                    <#if errorePartitaIVA??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> ${errorePartitaIVA}
                    </div>
                </#if>
                    <label class="input">
                        <input type="text" <#if errorePartitaIVA??> class="error" </#if> placeholder="Codice Fiscale o Partita IVA" name="PartitaIVA" <#if partitaIVA??> value="${partitaIVA}" </#if> required>
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
                            <#if erroreNomeRappresentante??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> ${erroreNomeRappresentante}
                    </div>
                </#if>
                            <label class="input">
                                <input type="text" <#if erroreNomeRappresentante??> class="error" </#if> placeholder="Nome Rappresentante Aziendale" name="NomeRappresentante"
                                        <#if nomeRappresentante??> value="${nomeRappresentante}" </#if>  required>
                            </label>
                        </div>
                        <div class="col-md-6">
                            <#if erroreCognomeRappresentante??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> ${erroreCognomeRappresentante}
                    </div>
                </#if>
                            <label class="input">
                                <input type="text" <#if erroreCognomeRappresentante??> class="error" </#if> placeholder="Cognome Rappresentante Aziendale"
                                       name="CognomeRappresentante" <#if cognomeRappresentante??> value="${cognomeRappresentante}" </#if> required>
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
                            <#if erroreNomeResponsabile??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> ${erroreNomeResponsabile}
                    </div>
                </#if>
                            <label class="input">
                                <input type="text" <#if erroreNomeResponsabile??> class="error" </#if> placeholder="Nome Responsabile" name="NomeResponsabile" <#if nomeResponsabile??> value="${nomeResponsabile}" </#if> required>
                            </label>
                        </div>
                        <div class="col-md-6">
                            <#if erroreCognomeResponsabile??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> ${erroreCognomeResponsabile}
                    </div>
                </#if>
                            <label class="input">
                                <input type="text" <#if erroreCognomeResponsabile??> class="error" </#if> placeholder="Cognome Responsabile" name="CognomeResponsabile"
                                        <#if cognomeResponsabile??> value="${cognomeResponsabile}" </#if> required>
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
                    <#if erroreNumeroTelefonoResponsabile??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> Attenzione, errore numero di telefono non valido o mancante.
                    </div>
                </#if>
                    <label class="input">
                        <input type="tel" <#if erroreNumeroTelefonoResponsabile??> class="error" </#if> placeholder="Numero di telefono" name="NumeroTelefonoResponsabile"
                                <#if numeroTelefonoResponsabile??> value="${numeroTelefonoResponsabile}" </#if> required>
                    </label>
                </div>
            </div>
            <div class="row">
                <div class="col-md-auto mt-6">
                    <h4>Indirizzo email del responsabile dei tirocini: &nbsp;</h4>
                </div>
                <div class="col-md-12 col-lg">
                    <#if erroreEmailResponsabile??>
                    <div class="alert alert-danger mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Errore!</strong> Attenzione, errore email non valida o mancante.
                    </div>
                </#if>
                    <label class="input">
                        <input type="email" <#if erroreEmailResponsabile??> class="error" </#if> placeholder="Email responsabile" name="EmailResponsabile" <#if emailResponsabile??> value="${emailResponsabile}" </#if> required>
                    </label>
                </div>
            </div>
        </fieldset>
        <footer>
            <button type="submit" form="form_registrazione" class="btn btn-success btn-lg pull-right float-right"><i
                    class="fa fa-check"></i> Crea il tuo Account
            </button>
            <a href="/registrazione">
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
