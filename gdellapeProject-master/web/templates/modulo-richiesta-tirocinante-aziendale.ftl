<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Richiesta Tirocinio</title>

    <#include "importCss.ftl">
    <link href="/css/print.css" rel="stylesheet" type="text/css" media="print">

</head>
<body class="enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130 d-print-none"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>IL MIO ACCOUNT</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li><a href="/account/moduli">Moduli</a></li>
                <li>Modulo Richiesta Tirocinio</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <form id="modulo_tirocinante" action="/account/moduli/richiesta-tirocinante" method="post" class="m-0">
                <fieldset>
                    <#if idRichiesta??><input name="idRichiesta" type="hidden" value="${idRichiesta}"></#if>
                    <h1 class="text-center fw-100 d-print-none">Controlla i dati del modulo pre-compilato e clicca su
                        stampa</h1>

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
                    <h4 class="fw-700 text-justify mr-10 fs-22 mb-25 d-none d-print-block">alla Convenzione per lo
                        svolgimento di attivit&agrave; di tirocinio e di orientamento (ai
                        sensi dell&apos;art. 18 L.196/97 e dell&apos;Art. 1 Decreto Ministero del Lavoro e Previdenza
                        Sociale N. 142/98 e della Legge 148 del 14/09/2011) per studenti, laureati e diplomati
                        del Dipartimento di Ingegneria, Scienze dell&rsquo;Informazione e Matematica
                        dell&rsquo;Universit&agrave; degli Studi dell&apos;Aquila.
                    </h4>
                    <h3 class="fw-700 text-center d-none d-print-block mb-25">PROGETTO FORMATIVO E DI ORIENTAMENTO</h3>


                    <div class="row mb-0 mr-10 ">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Nominativo del tirocinante </h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo"
                               value="${tirocinante.nome} ${tirocinante.cognome}"
                               placeholder="Nome e Cognome del tirocinante" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Nato a</h4>
                        <input class="input-modulo col-3 col-sm-3 col-md-6 col-lg-7 pl-0" type="text"
                               name="LuogoDiNascita" value="${tirocinante.luogoDiNascita}" placeholder="" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Prov</h4>
                        <input class="input-modulo col-1 col-sm pl-0" type="text" name="Provincia_di_nascita"
                               value="${tirocinante.provinciaDiNascita}" placeholder="XX" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">il</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Giorno_di_nascita"
                               value="${giorno}" placeholder="XX" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Mese_di_nascita"
                               value="${mese}" placeholder="XX" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">/</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text" name="Anno_di_nascita"
                               value="${anno}" placeholder="XXXX" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Residente in</h4>
                        <input class="input-modulo col-8 col-sm-8 pl-0" type="text" name="Luogo_di_residenza"
                               value="${tirocinante.luogoDiResidenza}" placeholder="Luogo di residenza" disabled>
                        <h4 class="col-auto col-sm-auto fs-20 pr-0">Prov (</h4>
                        <input class="input-modulo text-center col col-sm pl-0" type="text"
                               name="Provincia_di_nascita" value="${tirocinante.provinciaDiResidenza}" placeholder="XX"
                               disabled>
                        <h4 class="col-1 col-sm-1 pr-10 fs-20 pl-0">)</h4>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Codice fiscale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Codice_fiscale"
                               value="${tirocinante.codiceFiscale}" placeholder="Codice fiscale" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Numero_telefono"
                               value="${tirocinante.telefono}" placeholder="Numero di telefono" disabled>
                    </div>

                    <h4 class="text-center text-black fs-16 mb-5 mt-15 mr-10">Attuale condizione (barrare la casella -
                        possibilit&agrave; di scelta multipla):</h4>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1"
                                   <#if tirocinante.corsoDiLaurea??><#if tirocinante.corsoDiLaurea?has_content>checked="checked"</#if></#if>
                                   disabled>
                            <i></i> Studente Corso di Laurea in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="CorsoLaurea"
                               <#if tirocinante.corsoDiLaurea??><#if tirocinante.corsoDiLaurea?has_content>value="${tirocinante.corsoDiLaurea}"</#if></#if>
                               placeholder="Corso di laurea" disabled>
                    </div>

                    <div class="row mb-0 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1"
                                   <#if tirocinante.diplomaUniversitario??><#if tirocinante.diplomaUniversitario?has_content>checked="checked"</#if></#if>
                                   disabled>
                            <i></i> Diplomato. Diploma universitario in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="DiplomatoUniversitario"
                               <#if tirocinante.diplomaUniversitario??><#if tirocinante.diplomaUniversitario?has_content>value="${tirocinante.diplomaUniversitario}"</#if></#if>
                               placeholder="Diploma Universitario" disabled>
                    </div>
                    <h4>(entro 12 mesi dal diploma)</h4>

                    <div class="row mb-0 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1"
                                   <#if tirocinante.laureato??><#if tirocinante.laureato?has_content>checked="checked"</#if></#if>
                                   disabled>
                            <i></i> Laureato. Laurea in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Laurea"
                               <#if tirocinante.laureato??><#if tirocinante.laureato?has_content>value="${tirocinante.laureato}"</#if></#if>
                               placeholder="Laurea" disabled>
                    </div>
                    <h4>(entro 12 mesi dalla laurea)</h4>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1"
                                   <#if tirocinante.dottoratoDiRicerca??><#if tirocinante.dottoratoDiRicerca?has_content>checked="checked"</#if></#if>
                                   disabled>
                            <i></i> Dottorato di ricerca in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Dottorato_ricerca"
                               <#if tirocinante.dottoratoDiRicerca??><#if tirocinante.dottoratoDiRicerca?has_content>value="${tirocinante.dottoratoDiRicerca}"</#if></#if>
                               placeholder="Dottorato" disabled>
                    </div>

                    <div class="row mb-25 pl-15 mr-10">
                        <label class="checkbox">
                            <input type="checkbox" value="1"
                                   <#if tirocinante.scuolaAltro??><#if tirocinante.scuolaAltro?has_content>checked="checked"</#if></#if>
                                   disabled>
                            <i></i> Scuola o corso di perfezionamento o specializzazione in:
                        </label>
                        <input class="input-modulo col col-sm pl-0" type="text" name="ScuolaAltro"
                               <#if tirocinante.scuolaAltro??><#if tirocinante.scuolaAltro?has_content>value="${tirocinante.scuolaAltro}"</#if></#if>
                               placeholder="Specificare" disabled>
                    </div>
                    <div class="row">
                    <h4 class="col-auto">Barrare se trattasi di soggetto portatore di handicap:</h4>
                        <div class="col">
                    <label class="checkbox ml-15 mr-10">
                        <input type="checkbox" name="Handicap" value="Si"
                               <#if tirocinante.handicap == true>checked="checked"</#if> disabled>
                        <i></i> Si
                    </label><br>
                    <label class="checkbox ml-15 mb-25 mr-10">
                        <input type="checkbox" name="Handicap" value="No"
                               <#if tirocinante.handicap == false>checked="checked"</#if> disabled>
                        <i></i> No
                    </label><br>
                        </div>
                    </div>
                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Ente/Azienda ospitante</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nome_ente_azienda"
                               <#if azienda.ragioneSociale??><#if azienda.ragioneSociale?has_content>value="${azienda.ragioneSociale}"</#if></#if>
                               placeholder="Nome Ente/Azienda" disabled>
                    </div>

                    <div class="row mb-0 breack-print mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Luogo di effettuazione del tirocinio</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Luogo_di_svolgimento"
                               <#if offerta.luogoEffettuazione??><#if offerta.luogoEffettuazione?has_content>value="${offerta.luogoEffettuazione}"</#if></#if>
                               placeholder="Luogo di svolgimento" disabled>
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
                               <#if offerta.settoreInserimento??><#if offerta.settoreInserimento?has_content>value="${offerta.settoreInserimento}"</#if></#if>
                               placeholder="Settore di inserimento" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tempi di accesso ai locali aziendali</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Tempo_accesso_azienda"
                               <#if offerta.tempoAccessoLocaliAziendali??><#if offerta.tempoAccessoLocaliAziendali?has_content>value="${offerta.tempoAccessoLocaliAziendali}"</#if></#if>
                               placeholder="Specificare i tempi di accesso" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">Periodo di tirocinio n.</h4>
                        <input class="input-modulo col col-sm-1 pl-0 text-center" type="number" name="Numero_di_mesi"
                               <#if offerta.durataMesi??><#if offerta.durataMesi?has_content>value="${offerta.durataMesi}"</#if></#if>
                               placeholder="Specificare il numero di mesi" disabled>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">mesi dal</h4>
                        <input  class="input-modulo col col-sm pl-0" type="date" name="PeriodoInizio"
                               <#if offerta.periodoInizio??><#if offerta.periodoInizio?has_content>value="${offerta.periodoInizio?date?iso_utc}"</#if></#if>
                               placeholder="Data inizio" required>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20 mb-0">al</h4>
                        <input class="input-modulo col col-sm pl-0" type="date" name="PeriodoFine"
                               <#if offerta.periodoFine??><#if offerta.periodoFine?has_content>value="${offerta.periodoFine?date?iso_utc}"</#if></#if>
                               placeholder="Data fine" required>
                    </div>
                    <h4>(con possibilit&agrave; di prologa entro i limiti massimi previsti dalla normativa vigente)</h4>

                    <div class="row mb-25 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">numero ore di tirocinio </h4>
                        <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="NumeroOreTirocinio"
                               <#if offerta.durataOre??><#if offerta.durataOre?has_content>value="${offerta.durataOre}"</#if></#if>
                               placeholder="numero ore" required>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">per il conseguimento di n.</h4>
                        <input class="input-modulo col-2 col-sm-2 pl-0" type="text" name="NumeroCfu"
                               <#if tirocinio.CFU??><#if tirocinio.CFU?has_content>value="${tirocinio.CFU}"</#if></#if>
                               placeholder="Numero CFU" required>
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">CFU</h4>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore universitario</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Nominativo_tutore_universitario"
                               value="<#if tutore.nome?? && tutore.cognome??>${tutore.nome} ${tutore.cognome}</#if>"
                               placeholder="Nominativo tutore universitario" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Numero_telefono_tutore_universitario"
                               value="<#if tutore.telefono??>${tutore.telefono}</#if>"
                               placeholder="Numero di telefono tutore universitario" disabled>
                    </div>

                    <div class="row mb-0 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Tutore Aziendale</h4>
                        <input class="input-modulo col col-sm pl-0" type="text" name="Nominativo_tutore_aziendale"
                               value="<#if offerta.nomeTutoreAziendale?? && offerta.cognomeTutoreAziendale??>${offerta.nomeTutoreAziendale} ${offerta.cognomeTutoreAziendale}</#if>"
                               placeholder="Nominativo tutore aziendale" disabled>
                    </div>

                    <div class="row mb-25 mr-10">
                        <h4 class="col-auto col-sm-auto pr-10 fs-20">Telefono</h4>
                        <input class="input-modulo col col-sm pl-0" type="text"
                               name="Numero_telefono_tutore_aziendale"
                               value="<#if offerta.telefonoTutoreAziendale??>${offerta.telefonoTutoreAziendale}</#if>"
                               placeholder="Numero di telefono tutore aziendale" disabled>
                    </div>
                    <h3 class="mb-0 d-none d-print-block">Polize assicurative:</h3>
                    <h4 class="mb-5 d-none d-print-block">Copertura assicurativa per rischio responsabilit&agrave;
                        civile terzi:</h4>
                    <h4 class="fw-100 mb-5 d-none d-print-block">Compagnia assicurativa:<br>
                        UNIPOLSAI n.65 / 102965221<br>
                        Scadenza polizza: 30 aprile 2018</h4>
                    <h4 class="mb-5 d-none d-print-block">Copertura assicurativa per rischio infortuni:</h4>
                    <h4 class="fw-100 d-none d-print-block">Compagnia assicurativa:<br>
                        Copertura da polizza HARMONIE MUTUELLE n.100015<br>
                        Scadenza polizza: 30 aprile 2018 </h4>

                    <h3 class="mb-0 d-none d-print-block">Posizione INAIL:</h3>
                    <h4 class="mb-35 d-none d-print-block">Copertura assicurativa &ldquo;in conto Stato&rdquo; ex art. 2
                        D.P.R. N. 156 del 9.04.1999</h4>

                    <h4 class="fs-20 mb-0">Obiettivi del tirocinio:</h4>
                    <textarea class="textarea-modulo col-12 pt-5 mb-15 mr-10" rows="4" cols="1"
                              name="ObiettiviTirocinio"
                              placeholder="descrivi in breve l&apos;obiettivo del tirocinio" disabled><#if offerta.obbiettivi??><#if offerta.obbiettivi?has_content>${offerta.obbiettivi}</#if></#if></textarea>

                    <h4 class="fs-20 mb-0">Modalit&agrave;:</h4>
                    <textarea class="textarea-modulo col-12 pt-5 mb-0 mr-10" rows="4" cols="1" name="ModalitaTirocinio"
                              placeholder="descrivi in breve l&apos;obiettivo del tirocinio" disabled><#if offerta.modalita??><#if offerta.modalita?has_content>${offerta.modalita}</#if></#if></textarea>

                    <h4 class="col-12 mt-35 fs-20 pl-0 mb-0">Facilitazioni previste: sussidio di formazione e servizi
                        aziendali
                        (mensa)</h4>
                    <div class="row pr-15 pl-15">
                        <input class="input-modulo col-6 pl-0 breack-print" type="text"
                           name="Facilitazioni"
                           <#if offerta.facilitazioni??><#if offerta.facilitazioni?has_content>value="${offerta.facilitazioni}"</#if></#if> disabled >
                        <input class="input-modulo col-6 pl-0 breack-print" type="text"
                               name="Facilitazioni"
                               <#if offerta.rimborsi??><#if offerta.rimborsi?has_content>value="${offerta.rimborsi}"</#if></#if> disabled>
                    </div>
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
                            conoscenze in merito all&apos;attivit&agrave; di ricerca dell&apos;Ente/Azienda, acquisiti
                            durante e dopo lo
                            svolgimento del tirocinio;
                        </li>
                        <li>Rispettare i regolamenti aziendali e le norme in materia di igiene e sicurezza;</li>
                        <li>Inviare al Dipartimento di Ingegneria, Scienze dell&rsquo;Informazione e Matematica
                            dell&apos;Universit&agrave; degli Studi dell&apos;Aquila, mensilmente, le presenze effettive
                            presso
                            l&apos;Azienda rilevate da una scheda che viene consegnata dall&rsquo;Azienda stessa all&apos;atto
                            della compilazione del presente Progetto.
                        </li>
                    </ul>

                    <p class="text-black  text-justify fs-20 d-none d-print-block mr-10">
                        Ai sensi degli artt. 10 e seguenti della legge 675/ 96, sulla tutela delle persone e di altri
                        soggetti rispetto al trattamento dei dati personali, con la sottoscrizione il tirocinante
                        esprime il suo consenso a che i suoi dati personali vengano comunicati all&apos;Universit&agrave;
                        limitatamente ai trattamenti connessi alle finalit&agrave; del presente rapporto di tirocinio.
                        La
                        sottoscrizione del presente modello comporta anche il consenso del tirocinante al
                        trattamento dei suoi dati personali nel senso sopraindicato.
                        L&apos;Aquila
                    </p>
                    <h4 class="d-none d-print-block">Firma per visione e accettazione del tirocinante</h4>

                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Dipartimento di Ingegneria, Scienze dell&rsquo;Informazione e
                        Matematica dell&rsquo;Universit&agrave; degli Studi di L&apos;Aquila<br>
                        Il Tutor</h4>

                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">L&apos;Ente/Azienda <sup>1</sup></h4>
                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Il Tutor aziendale</h4>
                    <div class="linea col-5 p-0"></div>

                    <h4 class="d-none d-print-block">Il Direttore del Dipartimento di Ingegneria e Scienze dell&rsquo;Informazione
                        e Matematica.<br>
                        Prof. Guido Proietti
                    </h4>

                    <div class="linea col-5 p-0"></div>

                    <div class="linea col-3 p-0"></div>

                    <h5 class="fw-800 d-none d-print-block"><sup>1</sup>Timbro e firma dell&rsquo;Azienda</h5>

                    <footer class="mt-50 d-print-none">
                        <button type="submit" form="modulo_tirocinante"
                                class="btn btn-success btn-lg pull-right float-right" onclick="window.print();"><i
                                    class="fa fa-check"></i> Stampa
                        </button>
                        <button type="reset" form="modulo_tirocinante" class="btn btn-red btn-lg pull-right float-left">
                            <i
                                    class="fa fa-times"></i> Annulla
                        </button>
                    </footer>
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