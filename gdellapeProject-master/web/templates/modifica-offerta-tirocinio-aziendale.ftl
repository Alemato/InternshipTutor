<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Creazione Offerta di Tirocinio</title>

    <#include "importCss.ftl">

</head>
<body class="enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>Gestione Tirocinio</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li><a href="/account/gestione-offerte">Gestione Tirocinio</a></li>
                <li>Modifica Offerta</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>
    <section id="centrale" class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="form_modifica" action="/account/gestione-offerte/edit" method="post"
                  class="sky-form  boxed"
                  novalidate="novalidate">

                <header class="mb-50 fs-50 fw-100 text-center">Modifica un&apos;offerta di tirocinio</header>
                <fieldset name="Modifica">
                    <#if idofferta??>
                        <input type="hidden" name="IDOfferta" value="${idofferta}">
                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Titolo:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreTitolo??>class="error" </#if>placeholder="Titolo"
                                           name="Titolo" <#if ValueOfTitolo??> value="${ValueOfTitolo}" </#if> required>
                                </label>
                                <#if ErroreTitolo??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreTitolo}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Breve Descrizione:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <div class="fancy-form">
                                <textarea rows="3"
                                          class="form-control form-control-1 word-count <#if ErroreDescrizione_Breve??>error</#if>"
                                          data-maxlength="50"
                                          data-info="textarea-descrizione_breve" name="Descrizione_Breve"
                                          placeholder="Scrivi una breve descrizione dell&apos;offerta di tirocinio  questa descrizione apparir&agrave; nel anteprima del offerta"><#if ValueOfDescrizione_Breve??> ${ValueOfDescrizione_Breve} </#if></textarea>
                                    <i class="fa fa-font"><!-- icon --></i>

                                    <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 50 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-descrizione_breve">0/50</span> Parole
		                            </span>
	                            </span>
                                </div>
                                <#if ErroreDescrizione_Breve??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreDescrizione_Breve}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Descrizione Completa:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <div class="fancy-form">
                                <textarea rows="5"
                                          class="form-control form-control-1 word-count<#if ErroreDescrizione_Completa??> error</#if>"
                                          data-maxlength="200"
                                          data-info="textarea-descrizione_completa" name="Descrizione_Completa"
                                          placeholder="Scrivi una descrizione completa ed esaustiva dell'offerta di tirocinio"><#if ValueOfDescrizione_Completa??> ${ValueOfDescrizione_Completa} </#if></textarea>
                                    <i class="fa fa-font"><!-- icon --></i>

                                    <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 200 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-descrizione_completa">0/200</span> Parole
		                            </span>
	                            </span>
                                </div>
                                <#if ErroreDescrizione_Completa??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreDescrizione_Completa}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Orari di svolgimento attivit&agrave;:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreOrari??>class="error"
                                           </#if>placeholder="esempio: 8:00 - 19:00 orario continuo" name="Orari"
                                            <#if ValueOfOrari??> value="${ValueOfOrari}" </#if> required>
                                </label>
                                <#if ErroreOrari??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreOrari}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Durata ore:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="number" <#if ErroreDurara_Ora??>class="error" </#if>placeholder="ore"
                                           name="Durara_Ora"
                                            <#if ValueOfDurara_Ora??> value="${ValueOfDurara_Ora}" </#if> disabled>
                                </label>
                                <#if ErroreDurara_Ora??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreDurara_Ora}
                                    </div>
                                </#if>
                            </div>
                            <div class="col-md-auto mt-6">
                                <h4>Durata Mesi:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="number" <#if ErroreDurara_Mesi??>class="error"
                                           </#if>placeholder="N Mesi" name="Durara_Mesi"
                                            <#if ValueOfDurara_Mesi??> value="${ValueOfDurara_Mesi}" </#if> required>
                                </label>
                                <#if ErroreDurara_Mesi??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreDurara_Mesi}
                                    </div>
                                </#if>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Periodo Dall:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="date" <#if ErrorePeriodo_inizio??>class="error"
                                           </#if>name="Periodo_inizio" <#if ValueOfPeriodo_inizio??> value="${ValueOfPeriodo_inizio?date?iso_utc}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErrorePeriodo_inizio??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErrorePeriodo_inizio}
                                    </div>
                                </#if>
                            </div>
                            <div class="col-md-auto mt-6">
                                <h4>All:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="date" <#if ErrorePeriodo_fine??>class="error"
                                           </#if>name="Periodo_fine" <#if ValueOfPeriodo_fine??> value="${ValueOfPeriodo_fine?date?iso_utc}" </#if>
                                           required>
                                </label>
                                <#if ErrorePeriodo_fine??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErrorePeriodo_fine}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Modalit&agrave; di svolgimento:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreModalita??>class="error"
                                           </#if>placeholder="esempio: lavoro nel team aziendale"
                                           name="Modalita" <#if ValueOfModalita??> value="${ValueOfModalita}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreModalita??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreModalita}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Obbiettivi del tirocinio:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <div class="fancy-form">
                                <textarea rows="5"
                                          class="form-control form-control-1 word-count <#if ErroreObiettivi??>error</#if>"
                                          data-maxlength="200"
                                          data-info="textarea-obiettivi" name="Obiettivi"
                                          placeholder="Scrivi una descrizione completa ed esaustiva degli obiettivi dell'offerta di tirocinio"
                                          disabled="disabled"><#if ValueOfObiettivi??> ${ValueOfObiettivi} </#if></textarea>
                                    <i class="fa fa-font"><!-- icon --></i>

                                    <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 200 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-obiettivi">0/200</span> Parole
		                            </span>
	                            </span>
                                </div>
                                <#if ErroreObiettivi??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreObiettivi}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Rimborsi:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreRimborsi??>class="error"
                                           </#if>placeholder="esempio: eventuali rimborsi spese"
                                           name="Rimborsi" <#if ValueOfRimborsi??> value="${ValueOfRimborsi}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreRimborsi??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreRimborsi}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Facilitazioni previste:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreFacilitazioni??>class="error"
                                           </#if>placeholder="esempio: eventuali rimborsi spese"
                                           name="Facilitazioni" <#if ValueOfFacilitazioni??> value="${ValueOfFacilitazioni}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreFacilitazioni??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreFacilitazioni}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Luogo di effettuazione del tirocinio:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreSedeTirocinio??>class="error"
                                           </#if>placeholder="esempio: Presso l'azienda in via ..."
                                           name="SedeTirocinio" <#if ValueOfSedeTirocinio??> value="${ValueOfSedeTirocinio}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreSedeTirocinio??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreSedeTirocinio}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Codice del tirocinio:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreCodiceIdentTirocinio??>class="error"
                                           </#if>placeholder="esempio: DT0012151."
                                           name="CodiceIdentTirocinio" <#if ValueOfCodiceIdentTirocinio??> value="${ValueOfCodiceIdentTirocinio}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreCodiceIdentTirocinio??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreCodiceIdentTirocinio}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Settore di inserimento:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreSettoreInserimento??>class="error"
                                           </#if>placeholder="esempio: NON LO SO."
                                           name="SettoreInserimento" <#if ValueOfSettoreInserimento??> value="${ValueOfSettoreInserimento}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreSettoreInserimento??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione!</strong>${ErroreSettoreInserimento}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Tempi di accesso locali aziendali:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErrorErroreTempiAccessoLocaliAziendali??>class="error"
                                           </#if>placeholder="Tempi Accesso Locali"
                                           name="TempiAccessoLocaliAziendali" <#if ValueOfTempiAccessoLocaliAziendali??> value="${ValueOfTempiAccessoLocaliAziendali}" </#if>
                                           required>
                                </label>
                                <#if ErroreTempiAccessoLocaliAziendali??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreTempiAccessoLocaliAziendali}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Nome Tutore Aziendale:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreNomeTutoreAziendale??>class="error"
                                           </#if>placeholder="Nome"
                                           name="NomeTutoreAziendale" <#if ValueOfNomeTutoreAziendale??> value="${ValueOfNomeTutoreAziendale}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreNomeTutoreAziendale??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreNomeTutoreAziendale}
                                    </div>
                                </#if>
                            </div>

                            <div class="col-md-auto mt-6">
                                <h4>Cognome Tutore Aziendale:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" <#if ErroreCognomeTutoreAziendale??>class="error"
                                           </#if>placeholder="Cognome."
                                           name="CognomeTutoreAziendale" <#if ValueOfCognomeTutoreAziendale??> value="${ValueOfCognomeTutoreAziendale}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreCognomeTutoreAziendale??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreCognomeTutoreAziendale}
                                    </div>
                                </#if>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Telefono Tutore Aziendale:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="tel" <#if ErroreTelefonoTutoreAziendale??>class="error"
                                           </#if>placeholder="Telefono."
                                           name="TelefonoTutoreAziendale" <#if ValueOfTelefono??> value="${ValueOfTelefono}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreTelefonoTutoreAziendale??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreTelefonoTutoreAziendale}
                                    </div>
                                </#if>
                            </div>

                            <div class="col-md-auto mt-6">
                                <h4>Email Tutore Aziendale:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="email" <#if ErroreEmailTutoreAziendale??>class="error"
                                           </#if>placeholder="Email."
                                           name="EmailTutoreAziendale" <#if ValueOfEmailTutoreAziendale??> value="${ValueOfEmailTutoreAziendale}" </#if>
                                           disabled="disabled">
                                </label>
                                <#if ErroreEmailTutoreAziendale??>
                                    <div class="alert alert-danger mb-30">
                                        <button type="button" class="close" data-dismiss="alert">
                                            <span aria-hidden="true">&times;</span>
                                            <span class="sr-only">Chiudi</span>
                                        </button>
                                        <strong>Attenzione! </strong>${ErroreEmailTutoreAziendale}
                                    </div>
                                </#if>
                            </div>
                        </div>
                    <#else>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Attenzione Errore!</strong> Si &egrave; verificato un errore interno e non
                            &egrave; stato possibile presentare correttamente la pagina.<br> Si prega di ricaricare la
                            pagina, se errore susiste ancora contattare l&apos;amministratore.
                        </div>
                    </#if>
                </fieldset>

                <footer class="text-center text-sm-right">
                    <button type="submit" form="form_modifica"
                            class="btn btn-primary btn-lg pull-right float-sm-right mb-20"><i
                                class="fa fa-check"></i> Modifica Offerta
                    </button>
                </footer>

            </form>
        </div>
    </section>
    <#include "footer.ftl">
</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">

</body>
</html>
