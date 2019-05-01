<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Moduli</title>

    <#include "importCss.ftl">
    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">

</head>
<body class="enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130 d-print-none"
             style="background-image:url('imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>IL MIO ACCOUNT</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li><a href="/account/moduli">Tirocini e Moduli</a></li>
                <li>Modulo Tirocinio</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="modulo_tirocinante" action="/account/moduli/richiesta-tirocinio?id=${tirocinio.IDTirocinio}" method="post" class="m-0">
                <fieldset>
                    <h1 class="text-center fw-100 d-print-none">Controlla i dati del modulo pre-compilato e clicca su stampa</h1>

                    <div class="text-center d-none d-print-block">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>
                    <div class="sergreteria-box mr-10 mb-15 d-none d-print-block">
                        <div class="row">
                            <div class="col pl-35 pt-10 pb-10">
                                <h4 class="fw-100">PARTE RISERVATA</h4>
                                <h4 class="fw-100 mb-0">ALL&rsquo;UNIVERSITA&rsquo;</h4>
                            </div>
                            <div class="col pt-10 pb-10">
                                <h4 class="fw-100">DATA DI RICEVIMENTO:__________________</h4>
                                <h4 class="fw-100 mb-0">Prot. N:__________________</h4>
                            </div>
                        </div>
                    </div>

                    <h3 class="fw-700 text-center mb-0 d-none d-print-block">ALLEGATO 1</h3>
                    <h4 class="fw-700 text-justify mr-10 fs-22 mb-25 d-none d-print-block">alla Convenzione per lo svolgimento di attivit&agrave; di tirocinio e di orientamento (ai
                        sensi dell&apos;art. 18 L.196/97 e dell&apos;Art. 1 Decreto Ministero del Lavoro e Previdenza
                        Sociale N. 142/98 e della Legge 148 del 14/09/2011) per studenti, laureati e diplomati
                        del Dipartimento di Ingegneria, Scienze dell&rsquo;Informazione e Matematica
                        dell&rsquo;Universit&agrave; degli Studi dell&apos;Aquila.
                    </h4>
                    <h3 class="fw-700 text-center d-none d-print-block mb-25">PROGETTO FORMATIVO E DI ORIENTAMENTO</h3>



                    <div class="row mb-0 mr-10 ">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Nominativo del tirocinante </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo"
                               value="${tirocinante.nome} ${tirocinante.cognome}" placeholder="Nome e Cognome del tirocinante" <#if PdfStampato??>disabled</#if>>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Nato a</h4>
                        <input class="input-modulo col-3 col-sm-3 col-md-6 col-lg-7 pl-0" type="text"
                               name="LuogoDiNascita" value="${tirocinante.luogoDiNascita}" placeholder="" <#if PdfStampato??>disabled</#if>>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Prov</h4>
                        <input class="input-modulo col-1 col-sm pl-0" type="text" name="Provincia_di_nascita"
                               value="${tirocinante.provinciaDiNascita}" placeholder="XX" <#if PdfStampato??>disabled</#if>>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">il</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Giorno_di_nascita"
                               value="${giorno}" placeholder="XX" <#if PdfStampato??>disabled</#if>>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Mese_di_nascita"
                               value="${mese}" placeholder="XX" <#if PdfStampato??>disabled</#if>>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Anno_di_nascita"
                               value="${anno}" placeholder="XXXX" <#if PdfStampato??>disabled</#if>>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Residente in</h4>
                        <input class="input-modulo col-8 col-sm-8 pl-0" type="text" name="Luogo_di_residenza"
                               value="${tirocinante.luogoDiResidenza}" placeholder="Luogo di residenza" <#if PdfStampato??>disabled</#if>>
                        <h4 class="col-auto col-sm-auto fs-20 pr-0">Prov (</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text"
                               name="Provincia_di_nascita" value="${tirocinante.provinciaDiResidenza}" placeholder="XX" <#if PdfStampato??>disabled</#if>>
                        <h4 class="col-1 col-sm-1 pr-10 fs-20 pl-0">)</h4>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Codice fiscale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Codice_fiscale"
                               value="${tirocinante.codiceFiscale}" placeholder="Codice fiscale" <#if PdfStampato??>disabled</#if>>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Numero_telefono"
                               value="${tirocinante.telefono}" placeholder="Numero di telefono" <#if PdfStampato??>disabled</#if>>
                    </div>

                    <h4 class="text-center text-black fs-16 mb-5 mt-15 mr-10">Attuale condizione (barrare la casella -
                        possibilità di scelta multipla):</h4>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckCorsoDilaurea == true>1<#else>0</#if>" <#if ckCorsoDilaurea == true>checked="checked"</#if> <#if PdfStampato??>disabled</#if>>
                            <i></i> Studente Corso di Laurea in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="CorsoLaurea"
                               value="<#if ckCorsoDilaurea == true>${tirocinante.corsoDiLaurea}</#if>" placeholder="Corso di laurea" <#if PdfStampato??>disabled</#if>>
                    </div>

                    <div class="row mb-0 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckDiplomaUniversitario == true>1<#else>0</#if>" <#if ckDiplomaUniversitario == true>checked="checked"</#if> <#if PdfStampato??>disabled</#if>>
                            <i></i> Diplomato. Diploma universitario in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="DiplomatoUniversitario"
                               value="<#if ckDiplomaUniversitario == true>${tirocinante.diplomaUniversitario}</#if>" placeholder="Diploma Universitario" <#if PdfStampato??>disabled</#if>>
                    </div>
                    <h4>(entro 12 mesi dal diploma)</h4>

                    <div class="row mb-0 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckLaureato == true>1<#else>0</#if>" <#if ckLaureato == true>checked="checked"</#if> <#if PdfStampato??>disabled</#if>>
                            <i></i> Laureato. Laurea in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Laurea" value="<#if ckLaureato == true>${tirocinante.laureato}</#if>"
                               placeholder="Laurea" <#if PdfStampato??>disabled</#if>>
                    </div>
                    <h4>(entro 12 mesi dalla laurea)</h4>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckDottoratoDiRicerca == true>1<#else>0</#if>"  <#if ckDottoratoDiRicerca == true>checked="checked"</#if> <#if PdfStampato??>disabled</#if>>
                            <i></i> Dottorato di ricerca in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Dottorato_ricerca"
                               value="<#if ckDottoratoDiRicerca == true>${tirocinante.dottoratoDiRicerca}</#if>" placeholder="Dottorato" <#if PdfStampato??>disabled</#if>>
                    </div>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="<#if ckScuolaAltro == true>1<#else>0</#if>" <#if ckScuolaAltro == true>checked="checked"</#if> <#if PdfStampato??>disabled</#if>>
                            <i></i> Scuola o corso di perfezionamento o specializzazione in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="ScuolaAltro" value="<#if ckScuolaAltro == true>${tirocinante.scuolaAltro}</#if>"
                               placeholder="Specificare" <#if PdfStampato??>disabled</#if>>
                    </div>

                    <h4>Barrare se trattasi di soggetto portatore di handicap:</h4>
                    <label class="checkbox ml-200 mr-10">
                        <input type="checkbox" name="Handicap" value="Si" <#if handicap == true>checked="checked"</#if> <#if PdfStampato??>disabled</#if>>
                        <i></i> Si
                    </label><br>
                    <label class="checkbox ml-200 mb-25 mr-10">
                        <input type="checkbox" name="Handicap" value="No" <#if handicap == false>checked="checked"</#if> <#if PdfStampato??>disabled</#if>>
                        <i></i> No
                    </label><br>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Ente/Azienda ospitante</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nome_ente_azienda"
                               value="${azienda.ragioneSociale}" placeholder="Nome Ente/Azienda" disabled>
                    </div>

                    <div class="row mb-0 breack-print mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Luogo di effettuazione del tirocinio</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Luogo_di_svolgimento"
                               value="${offertatirocinio.luogoEffettuazione}" placeholder="Luogo di svolgimento" disabled>
                    </div>

                    <div class="text-center d-none d-print-block mr-10">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Settore di inserimento</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Settore_di_inserimento"
                               value="${offertatirocinio.settoreInserimento}" placeholder="Settore di inserimento" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tempi di accesso ai locali aziendali</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Tempo_accesso_azienda"
                               value="${offertatirocinio.tempoAccessoLocaliAziendali}" placeholder="Specificare i tempi di accesso" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Periodo di tirocinio n.</h4>
                        <input class="input-modulo col col-sm-1 pl-0 text-center" type="text" name="Numero_di_mesi"
                               value="${offertatirocinio.durataMesi}" placeholder="Specificare il numero di mesi" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">mesi dal</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="PeriodoInizio"
                               value="${offertatirocinio.periodoInizio}" placeholder="Data inizio" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">al</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="PeriodoFine" value="${offertatirocinio.periodoFine}"
                               placeholder="Data fine" disabled>
                    </div>
                    <h4>(con possibilit&agrave; di prologa entro i limiti massimi previsti dalla normativa vigente)</h4>

                    <div class="row mb-25 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">numero ore di tirocinio </h4>
                        <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="NumeroOreTirocinio"
                               value="${offertatirocinio.durataOre}" placeholder="numero ore" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">per il conseguimento di n.</h4>
                        <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="NumeroCfu" value="${tirocinio.CFU}"
                               placeholder="Numero CFU" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">CFU</h4>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore universitario</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Nominativo_tutore_universitario" value="Mario Rossi"
                               placeholder="Nominativo tutore universitario" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Numero_telefono_tutore_universitario" value="333-1234567"
                               placeholder="Numero di telefono tutore universitario" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore Aziendale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo_tutore_aziendale"
                               value="Francesco Bianchi" placeholder="Nominativo tutore aziendale" disabled>
                    </div>

                    <div class="row mb-25 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Numero_telefono_tutore_aziendale" value="333-1234567"
                               placeholder="Numero di telefono tutore aziendale" disabled>
                    </div>
                    <h3 class="mb-0 d-none d-print-block">Polize assicurative:</h3>
                    <h4 class="mb-5 d-none d-print-block">Copertura assicurativa per rischio responsabilità civile terzi:</h4>
                    <h4 class="fw-100 mb-5 d-none d-print-block">Compagnia assicurativa:<br>
                        UNIPOLSAI n.65 / 102965221<br>
                        Scadenza polizza: 30 aprile 2018</h4>
                    <h4 class="mb-5 d-none d-print-block">Copertura assicurativa per rischio infortuni:</h4>
                    <h4 class="fw-100 d-none d-print-block">Compagnia assicurativa:<br>
                        Copertura da polizza HARMONIE MUTUELLE n.100015<br>
                        Scadenza polizza: 30 aprile 2018 </h4>

                    <h3 class="mb-0 d-none d-print-block">Posizione INAIL:</h3>
                    <h4 class="mb-35 d-none d-print-block">Copertura assicurativa “in conto Stato” ex art. 2 D.P.R. N. 156 del 9.04.1999</h4>

                    <h4 class="fs-20 mb-0">Obiettivi del tirocinio:</h4>
                    <textarea class="textarea-modulo col-12 pt-5 mb-15 mr-10" rows="4" cols="1" name="ObiettiviTirocinio"
                              placeholder="descrivi in breve l&apos;obiettivo del tirocinio" disabled>${offertatirocinio.obbiettivi}</textarea>

                    <h4 class="fs-20 mb-0">Modalit&agrave;:</h4>
                    <textarea class="textarea-modulo col-12 pt-5 mb-0 mr-10" rows="4" cols="1" name="ModalitaTirocinio"
                              placeholder="descrivi in breve l&apos;obiettivo del tirocinio" disabled>${offertatirocinio.modalita}</textarea>

                    <h4 class="col-12 mt-35 fs-20 pl-0 mb-0">Facilitazioni previste: sussidio di formazione e servizi
                        aziendali
                        (mensa)</h4>
                    <input class="input-modulo col-12 pl-0 breack-print" type="text"
                           name="Facilitazioni"
                           value="<#if offertatirocinio.facilitazioni??>${offertatirocinio.facilitazioni}<#else>Nessuna</#if>" disabled>

                    <div class="text-center d-none d-print-block">
                        <img class="img-fluid" src="/imgs/stemma_univaq.png" width="80">
                        <h1 class="Taviraji fw-600 uppercase mb-0">UNIVERSITA&apos; DEGLI STUDI DELL&apos;AQUILA</h1>
                        <h4 class="">Dipartimento di INGEGNERIA E SCIENZE DELL&rsquo;INFORMAZIONE E MATEMATICA</h4>
                        <h6>SEGRETERIA AMMINISTRATIVA PER LA DIDATTICA</h6>
                    </div>
                    <h4 class="col-12 mt-35 fs-20 pl-0 mb-5 d-none d-print-block mr-10">Obblighi del tirocinante:</h4>
                    <ul class="d-none d-print-block mr-10">
                        <li>Seguire le indicazioni dei tutori e fare riferimento ad essi su qualsiasi esigenza di tipo
                            organizzativo ed altre evenienze;
                        </li>
                        <li>Rispettare gli obblighi di riservatezza per quanto attiene ai dati, informazioni e
                            conoscenze in merito all'attività di ricerca dell'Ente/Azienda, acquisiti durante e dopo lo
                            svolgimento del tirocinio;
                        </li>
                        <li>Rispettare i regolamenti aziendali e le norme in materia di igiene e sicurezza;</li>
                        <li>Inviare al Dipartimento di Ingegneria, Scienze dell’Informazione e Matematica
                            dell'Università degli Studi dell'Aquila, mensilmente, le presenze effettive presso
                            l'Azienda rilevate da una scheda che viene consegnata dall’Azienda stessa all'atto
                            della compilazione del presente Progetto.
                        </li>
                    </ul>

                    <p class="text-black  text-justify fs-20 d-none d-print-block mr-10">
                        Ai sensi degli artt. 10 e seguenti della legge 675/ 96, sulla tutela delle persone e di altri
                        soggetti rispetto al trattamento dei dati personali, con la sottoscrizione il tirocinante
                        esprime il suo consenso a che i suoi dati personali vengano comunicati all'Università
                        limitatamente ai trattamenti connessi alle finalità del presente rapporto di tirocinio. La
                        sottoscrizione del presente modello comporta anche il consenso del tirocinante al
                        trattamento dei suoi dati personali nel senso sopraindicato.
                        L'Aquila
                    </p>
                    <h4 class="d-none d-print-block">Firma per visione e accettazione del tirocinante</h4>

                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Dipartimento di Ingegneria, Scienze dell’Informazione e Matematica dell’Università degli Studi di L'Aquila<br>
                        Il Tutor</h4>

                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">L&apos;Ente/Azienda <sup>1</sup></h4>
                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Il Tutor aziendale</h4>
                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Il Direttore del Dipartimento di Ingegneria e Scienze dell’Informazione e Matematica.<br>
                        Prof. Guido Proietti
                    </h4>

                    <div class="linea col-5 p-0"></div>

                    <div class="linea col-3 p-0"></div>

                    <h5 class="fw-800 d-none d-print-block"><sup>1</sup>Timbro e firma dell’Azienda</h5>

                    <#if PdfStampato??>
                    <#else>
                    <footer class="mt-50 d-print-none">
                        <button type="submit" form="modulo_tirocinante" class="btn btn-success btn-lg pull-right float-right" onclick="window.print();"><i
                                class="fa fa-check"></i> Stampa
                        </button>
                        <button type="reset" form="modulo_tirocinante" class="btn btn-red btn-lg pull-right float-left"><i
                                class="fa fa-times"></i> Annulla
                        </button>
                    </footer>
                    </#if>
                </fieldset>
            </form>
        </div>
    </section>

    <!-- /FOOTER -->
    <#include "footer.ftl">
    <!-- /FOOTER -->
</div>
<#include "importScript.ftl">
</body>
</html>