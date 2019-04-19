<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Registrazione - Parte 2</title>

    <#include "importCss.ftl">
</head>
<body class="enable-animation">

<div class="w-1000 mx-auto">
    <form id="form_registrazione" action="/registrazione" method="post" class="sky-form  boxed">
    <form id="form_registrazione" action="/registrazione" method="post" class="sky-form  boxed">

        <header class="mb-50 fs-50 fw-100 text-center">Crea Il Tuo Account</header>

        <div id="Tirocinante" class="header-form mb-30"><i class="fa fa-user"></i> INFORMAZIONI
            PERSONALI TIROCINANTE
        </div>
        <fieldset name="step-1" class="d-none">
            <input type="hidden" name="Email" value=${email}>
            <input type="password" class="d-none" name="Password" value=${password}>
            <input type="password" class="d-none" name="ConfermaPassword" value=${confermaPassword}>
            <input type="hidden" name="Tipologia" value="Tirocinante">
        </fieldset>
        <fieldset name="Tirocinante">
            <div class="row pr-15 mb-35">
                <div class="col-md-auto mt-6 pr-0">
                    <h4>Nominativo del tirocinante: </h4>
                </div>
                <div class="col">
                    <#if erroreNome??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> <#if erroreNome??>${erroreNome}</#if>
                        </div>
                    </#if>
                    <label class="input">
                        <input type="text" <#if erroreNome??>class="error"</#if> placeholder="Nome" name="Nome" <#if nome??>value="${nome}"</#if>required>
                    </label>
                </div>
                <div class="col col">
                    <#if erroreCognome??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore email non valida o mancante.
                        </div>
                    </#if>
                    <label class="input">
                        <input type="text" <#if erroreCognome??>class="error"</#if> placeholder="Cognome" name="Cognome"  <#if cognome??>value="${cognome}"</#if> required>
                    </label>
                </div>
            </div>

            <div class="row pr-15 mb-35">
                <div class="col-md-auto mt-6">
                    <h4>Nato a:</h4>
                </div>

                <div class="col">
                    <#if erroreLuogoNascita??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore email non valida o mancante.
                        </div>
                    </#if>
                    <label class="input">
                        <i class="ico-append fa fa-map-o"></i>
                        <input type="text" <#if erroreLuogoNascita??>class="error"</#if> placeholder="Luogo di Nascita" name="LuogoNascita" <#if luogoNascita??>value="${luogoNascita}"</#if> required>
                    </label>
                </div>

                <div class="col-md-auto mt-6">
                    <h4>Provincia: </h4>
                </div>
                <div class="col-md-1">

                    <label class="input">
                        <input type="text" <#if erroreProvinciaNascita??>class="error masked" <#else> class="masked"</#if> data-format="aa" placeholder="XX" name="ProvinciaNascita"
                                <#if provinciaNascita??>value="${provinciaNascita}"</#if>  required>
                    </label>
                </div>


                <div class="col-md-auto mt-6">
                    <h4>Il: </h4>
                </div>

                <div class="col">
                    <#if erroreDataNascita??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore data non valida o mancante.
                        </div>
                    </#if>
                    <label class="input">
                        <i class="ico-append fa fa-calendar"></i>
                        <input type="date" <#if erroreNome??>class="error"</#if> name="DataNascita" <#if dataNascita??>value="${dataNascita}"</#if> required>
                    </label>
                </div>
            </div>

            <div class="row pr-15 mb-35">
                <div class="col-md-auto mt-6 pr-0">
                    <h4>Residente in: </h4>
                </div>

                <div class="col">
                    <#if erroreLuogoResidenza??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore Luogo non valido o mancante.
                        </div>
                    </#if>
                    <label class="input">
                        <i class="ico-append fa fa-map-o"></i>
                        <input type="text" <#if erroreLuogoResidenza??>class="error"</#if> placeholder="Luogo di Residenza" name="LuogoResidenza" <#if luogoResidenza??>value="${luogoResidenza}"</#if> required>
                    </label>
                </div>

                <div class="col-md-auto mt-6">
                    <h4>Provincia: </h4>
                </div>

                <div class="col-md-1">
                    <label class="input">
                        <input type="text" <#if erroreProvinciaResidenza??>class="error masked" <#else> class="masked"</#if>  data-format="aa" data-placeholder="X" placeholder="XX"
                               name="ProvinciaResidenza" <#if provinciaResidenza??>value="${provinciaResidenza}" </#if> required>
                    </label>
                </div>

            </div>

            <div class="row pr-15 mb-35">
                <div class="col-md-auto mt-6 pr-0">
                    <h4>Codice Fiscale: </h4>
                </div>

                <div class="col">
                    <#if erroreCodiceFiscale??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> ${erroreCodiceFiscale}
                        </div>
                    </#if>
                    <label class="input mb-20">
                        <input type="text"  <#if erroreCodiceFiscale??>class="error" <#else> class="masked"</#if> data-format="****************" data-placeholder="X"
                               placeholder="Codice Fiscale" name="CodiceFiscale" <#if codiceFiscale??>value="${codiceFiscale}" </#if> required>
                    </label>
                </div>

                <div class="col-md-auto mt-6 pr-0">
                    <h4>Numero di Telefono: </h4>
                </div>

                <div class="col">
                    <#if erroreNumeroTelefono??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> ${erroreNumeroTelefono}
                        </div>
                    </#if>
                    <label class="input mb-20">
                        <i class="ico-append fa fa-phone"></i>
                        <input type="tel" <#if erroreNumeroTelefono??>class="error" </#if> placeholder="Numero di telefono" name="NumeroTelefono" <#if numeroTelefono??>value="${numeroTelefono}" </#if> required>
                    </label>
                </div>

            </div>

            <h4 class="text-center mb-10 mt-30">Attuale condizione :</h4>
            <h5 class="text-center fs-16 mb-30">(barrare la casella e compila la casella di testo a fianco &ndash;
                possibilit&agrave; di doppia scelta)</h5>

            <div class="row pr-15 pl-15 pr-15">
                <label class="checkbox mt-6">
                    <input type="checkbox" name="CKStudenteCorsoLaurea" value="1" <#if ckStudenteCorsoLaurea??>checked </#if>>
                    <i></i> Studente Corso di Laurea in:
                </label>
                <#if erroreStudenteCorsoLaurea??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore campo non valido o mancante.
                        </div>
                    </#if>
                <label class="input col">
                    <input type="text" <#if erroreStudenteCorsoLaurea??>class="error" </#if> placeholder="Corso di Laurea" name="StudenteCorsoLaurea" <#if studenteCorsoLaurea??>value="${studenteCorsoLaurea}" </#if>>
                </label>
            </div>

            <div class="row pl-15 pr-15">
                <label class="checkbox mt-6">
                    <input type="checkbox" name="CKDiplomaUniversitario" value="1" <#if ckDiplomaUniversitario??>checked </#if>>
                    <i></i> Diplomato. Diploma universitario in <em class="fw-100">(entro 12 mesi dal diploma)</em>
                    &nbsp;:
                </label>
                <#if erroreDiplomaUniversitario??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore campo non valido o mancante.
                        </div>
                    </#if>
                <label class="input col">
                    <input type="text" <#if erroreDiplomaUniversitario??>class="error" </#if> placeholder="Diploma universitario" name="DiplomaUniversitario" <#if diplomaUniversitario??>value="${diplomaUniversitario}" </#if>>
                </label>
            </div>

            <div class="row pl-15 pr-15">
                <label class="checkbox mt-6">
                    <input type="checkbox" name="CKLaureaIn" value="1" <#if ckLaureaIn??>checked </#if>>
                    <i></i> Laureato. Laurea in <em class="fw-100">(entro 12 mesi dalla laurea)</em> &nbsp;:
                </label>

                <label class="input col">
                    <#if erroreLaureaIn??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore email non valida o mancante.
                        </div>
                    </#if>
                    <input type="text" <#if erroreLaureaIn??>class="error" </#if> placeholder="Corso di Laurea" name="LaureaIn" <#if laureaIn??>value="${laureaIn}" </#if>>
                </label>
            </div>

            <div class="row pl-15 pr-15">
                <label class="checkbox mt-6">
                    <input type="checkbox" name="CKDottoratoRicerca" value="1" <#if ckDottoratoRicerca??>checked </#if>>
                    <i></i> Dottorato di ricerca in:
                </label>
                <label class="input col">
                    <#if erroreDottoratoRicerca??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore campo non valido o mancante.
                        </div>
                    </#if>
                    <input type="text" <#if erroreDottoratoRicerca??>class="error" </#if> placeholder="Corso di Laurea" name="DottoratoRicerca" <#if dottoratoRicerca??>value="${dottoratoRicerca}" </#if>>
                </label>
            </div>

            <div class="row pl-15 pr-15">
                <label class="checkbox mt-6 pr-0">
                    <input type="checkbox" name="CKScuolaAltro" value="1"  <#if ckScuolaAltro??>checked </#if> >
                    <i></i> Scuola o corso di perfezionamento o specializzazione in:
                </label>
                <label class="input col mb-80">
                    <#if erroreScuolaAltro??>
                        <div class="alert alert-danger mb-30">
                            <button type="button" class="close" data-dismiss="alert">
                                <span aria-hidden="true">&times;</span>
                                <span class="sr-only">Chiudi</span>
                            </button>
                            <strong>Errore!</strong> Attenzione, errore campo non valido o mancante.
                        </div>
                    </#if>
                    <input type="text" <#if erroreScuolaAltro??>class="error" </#if> placeholder="Corso di Laurea" name="ScuolaAltro" <#if scuolaAltro??>value="${scuolaAltro}" </#if>>
                </label>
            </div>

            <#if erroreHandicap??>
                <div class="alert alert-danger mb-30">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Errore!</strong> Attenzione, errore campo Handicap non valido o mancante.
                </div>
            </#if>
            <div class="row mb-100">
                <div class="col-md-auto mt-4">
                    <h4>Barrare se trattasi di soggetto portatore di handicap:</h4>
                </div>
                <div class="col-md-auto">
                    <label class="checkbox mt-6 pr-0">
                        <input type="checkbox" <#if erroreHandicap??> class="error" </#if> name="Handicap" value="Si">
                        <i></i> SI
                    </label>
                    <label class="checkbox mt-6 pr-0">
                        <input type="checkbox" <#if erroreHandicap??> class="error" </#if> name="Handicap" value="NO">
                        <i></i> NO
                    </label>
                </div>
            </div>

        </fieldset>


        <footer>
            <button type="submit" form="form_registrazione" class="btn btn-success btn-lg pull-right float-right"><i
                    class="fa fa-check"></i> Crea il tuo Account
            </button>
            <a href="/registration">
            <button type="button" form="form_registrazione" class="btn btn-red btn-lg pull-right float-left"><i
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
