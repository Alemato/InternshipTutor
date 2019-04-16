<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tutte Offerte Pubblicate</title>

    <#include "../importCss.ftl">
    <!-- Page Sript -->
    <link href="/css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="smoothscroll enable-animation">

<nav class="navbar navbar-toggleable-md navbar-inverse fixed-top bg-inverse navbar-large bg-dark">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse"
            data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand link-bar" href="index.html">Intership Tutor </a>
    <ol class="breadcrumb">
        <li><a href="admin.html">HOME DASHBOARD</a></li>
        <li><a href="gestione-tirocinii-admin.html">GESTIONE TIROCINII</a></li>
        <li class="active"><a href="tutte-offerte-pubblicate-admin.html"><b>TUTTE LE OFFERTE PUBBLICATE</b></a>
    </ol>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <div class="row">
                <a class="nav-link link-bar mt-5" href="#">Benvenuto, <b>ADMIN</b></a>
                <a class="nav-link link-bar text-center" href="#"><i class="fa fa-user-md fs-35 px-3"></i></a>
            </div>
        </li>
    </ul>

</nav>
<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar bg-light">
            <div class="side-nav mb-60">
                <ul class="list-group list-group-bordered list-group-noicon uppercase">
                    <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
                    <li class=""><a href="gestione-utenza-admin.html">GESTIONE UTENZA</a></li>
                    <li class=""><a href="gestione-richieste-convenzioni-admin.html">GESTIONE RICHIESTE CONVENZIONE</a>
                    </li>
                    <li class="list-group-item active">
                        <a class="dropdown-toggle" href="gestione-tirocinii-admin.html">GESTIONE TIROCINII</a>
                        <ul>
                            <li class=""><a href="ultime-offerte-pubblicate-admin.html">ULTIME OFFERTE PUBBLICATE</a>
                            </li>
                            <li class=""><a href="offerte-scadute-admin.html">OFFERTE SCADUTE</a></li>
                            <li class="active"><a href="tutte-offerte-pubblicate-admin.html">TUTTE LE OFFERTE PUBBLICATE</a>
                            </li>
                        </ul>
                    </li>
                    <li class="list-group-item">
                        <a class="dropdown-toggle" href="gestione-moduli-admin.html">GESTIONE MODULI</a>
                        <ul>
                            <li><a href="richieste-tirocinii-tirocinanti-admin.html">RICHIESTE TIROCINII TIROCINANTI</a>
                            </li>
                            <li><a href="richieste-convenzioni-aziendali-admmin.html">RICHIESTE CONVENZIONI
                                    AZIENDALI</a>
                            </li>
                            <li><a href="modulo-tirocinio-fine-admin.html">MODULO TIROCINIO FINE</a>
                            </li>
                        </ul>
                    </li>

                    <li class=""><a href="impostazione-account-admin.html">IMPOSTAZIONI ACCOUNT</a></li>
                    </li>
                </ul>
            </div>
        </nav>


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto
                        <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <form id="form_modifica" action="print.php" method="post" class="sky-form .validate boxed"
                  novalidate="novalidate">

                <header class="mb-50 fs-50 fw-100 text-center">Modifica l'offerta di tirocinio</header>
                <fieldset name="Modifica">
                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Titolo:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Titolo" name="Titolo"
                                       value="${offerta.titolo}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Breve Descrizione:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form">
                                <textarea rows="3" class="form-control form-control-1 word-count" data-maxlength="50"
                                          data-info="textarea-descrizione_breve" name="Descrizione_Breve"
                                          placeholder="Scrivi una breve descrizione dell'offerta di tirocinio  questa descrizione apparirà nel anteprima del offerta">${offerta.descrizioneBreve}</textarea>
                                <i class="fa fa-font"><!-- icon --></i>

                                <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 50 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-descrizione_breve">0/50</span> Parole
		                            </span>
	                            </span>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Descrizione Completa:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form">
                                <textarea rows="5" class="form-control form-control-1 word-count" data-maxlength="200"
                                          data-info="textarea-descrizione_completa" name="Descrizione_Completa"
                                          placeholder="Scrivi una descrizione completa ed esaustiva dell'offerta di tirocinio">${offerta.descrizione}</textarea>
                                <i class="fa fa-font"><!-- icon --></i>

                                <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 200 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-descrizione_completa">0/200</span> Parole
		                            </span>
	                            </span>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Orari di svolgimento attività:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: 8:00 - 19:00 orario continuo" name="Oriari"
                                       value="${offerta.orario}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Durata ore:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio 150 ore" name="Durara_Ora"
                                       value="${offerta.durataOra}" required>
                            </label>
                        </div>
                        <div class="col-md-auto mt-6">

                            <h4>Durata Mesi:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio 150 ore" name="Durara_Mesi"
                                       value="${offerta.durataMesi}" required>
                            </label>
                        </div>
                        <div class="col-md-auto mt-6">
                            <h4>Periodo Inizio presente : ${offerta.periodoInizio}</h4>
                            <h4>Periodo Dall:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="date" placeholder="01/01/2018" name="Periodo_inizio"
                                       required>
                            </label>
                        </div>
                        <div class="col-md-auto mt-6">
                            <h4>Periodo fine ${offerta.periodoFine}</h4>
                            <h4>All:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="date" placeholder="01/01/2018" name="Periodo_fine"
                                        required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Modalità di svolgimento:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: lavoro nel team aziendale" name="Modalita"
                                       value="${offerta.modalita}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Obbiettivi del tirocinio:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form">
                                <textarea rows="5" class="form-control form-control-1 word-count" data-maxlength="200"
                                          data-info="textarea-obiettivi" name="Obiettivi"
                                          placeholder="Scrivi una descrizione completa ed esaustiva degli obiettivi dell'offerta di tirocinio">${offerta.obbiettivi}</textarea>
                                <i class="fa fa-font"><!-- icon --></i>

                                <span class="fancy-hint fancy-hint-1 fs-11 text-muted">
		                            <strong>Suggerimento:</strong> 200 parole permesse!
		                            <span class="float-right">
			                                <span id="textarea-obiettivi">0/200</span> Parole
		                            </span>
	                            </span>

                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Rimborsi:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: eventuali rimborsi spese" name="Rimborsi"
                                       value="${offerta.rimborsi}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Facilitazioni previste:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: eventuali rimborsi spese" name="Facilitazioni"
                                       value="${offerta.facilitazioni}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Luogo di effettuazione del tirocinio:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: Presso l'azienda in via ..."
                                       name="AziendaOspitante"
                                       value="${offerta.aziendaOspitante}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Codice del tirocinio:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: DT0012151." name="CodiceIdentTirocinio"
                                       value="${offerta.codiceTirocinio}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Settore di inserimento:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="esempio: NON LO SO." name="SettoreInserimento"
                                       value="${offerta.settoreInserimento}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Orari Accesso locali aziendali:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Orari accesso"
                                       name="TempiAccessoLocaliAziendali"
                                       value="${offerta.tempoAccessoLocaliAziendali}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Nome Tutore Aziendale:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Nome"
                                       name="NomeTutoreAziendale"
                                       value="${offerta.nomeTutoreAziendale}" required>
                            </label>
                        </div>

                        <div class="col-md-auto mt-6">
                            <h4>Cognome Tutore Aziendale:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="text" placeholder="Cognome"
                                       name="CognomeTutoreAziendale"
                                       value="${offerta.cognomeTutoreAziendale}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Telefono Tutore Aziendale:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="tel" placeholder="Telefono."
                                       name="TelefonoTutoreAziendale"
                                       value="${offerta.telefonoTutoreAzindale}" required>
                            </label>
                        </div>

                        <div class="col-md-auto mt-6">
                            <h4>Email Tutore Aziendale:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <label class="input">
                                <input type="email" placeholder="Email."
                                       name="EmailTutoreAziendale"
                                       value="${offerta.emailTutoreAziendale}" required>
                            </label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-auto mt-6">
                            <h4>Tutore Universitario:&nbsp;</h4>
                        </div>
                        <div class="col">
                            <div class="fancy-form fancy-form-select">
                                <select id="TuroreUni" class="form-control select2" name="TutoreUniversitario">
                                    <#list tutori as tutTutore>
                                        <option value="${tutTutori.IDTutoreUni}" <#if tutTutore.IDTutoreUni==tutore.IDTutoreUni> selected</#if> >${tutTutore.nome} ${tutTutore.cognome}</option>
                                    </#list>
                                    <option value="NEW">Altro</option>
                                </select>

                                <i class="fancy-arrow-"></i>
                            </div>
                        </div>
                    </div>
                    <div id="NewTuroreUni" style="display: none">
                        <div class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Nome Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" placeholder="Nome"
                                           name="NomeTutoreUniversitario"
                                           required>
                                </label>
                            </div>

                            <div class="col-md-auto mt-6">
                                <h4>Cognome Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="text" placeholder="Cognome"
                                           name="CognomeTutoreUniversitario"
                                           required>
                                </label>
                            </div>
                        </div>

                        <div  class="row">
                            <div class="col-md-auto mt-6">
                                <h4>Telefono Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="tel" placeholder="Telefono."
                                           name="TelefonoTutoreUniversitario"
                                           required>
                                </label>
                            </div>

                            <div class="col-md-auto mt-6">
                                <h4>Email Tutore Universitario:&nbsp;</h4>
                            </div>
                            <div class="col">
                                <label class="input">
                                    <input type="email" placeholder="Email."
                                           name="EmailTutoreUniversitario"
                                           required>
                                </label>
                            </div>
                        </div>
                    </div>

                </fieldset>

                <footer class="text-center text-sm-right">
                    <button type="submit" form="form_modifica"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                class="fa fa-check"></i> Aggiorna
                    </button>
                    <button type="reset" form="form_modifica" class="btn btn-red btn-lg pull-right float-sm-left mb-20">
                        <i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>

        </main>
    </div>
</div>

<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->
<script src="plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.js"></script>
<script src="plugins/select2/js/select2.full.min.js"></script>
<script>
    $("#TuroreUni").change( function () {
        console.log($("#TuroreUni").val());
        if ($("#TuroreUni").val() == "NEW") {
            $("#NewTuroreUni").fadeIn("show");
        } else {
            $("#NewTuroreUni").fadeOut();
        }
    })
</script>

</body>
</html>
