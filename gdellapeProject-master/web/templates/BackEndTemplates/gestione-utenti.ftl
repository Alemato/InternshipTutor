<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Utenza</title>

   <#include "../importCss.ftl">

    <!-- Page Sript -->
    <link href="css/admin.css" rel="stylesheet" type="text/css"/>
    <!-- /Page Script -->

    <!-- CSS DATATABLES -->
    <link href="css/layout-datatables.css" rel="stylesheet" type="text/css"/>

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
        <li class="active"><a href="gestione-utenza-admin.html"><b>GESTIONE UTENZA</b></a></li>
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
       <#include "../BackEndTemplates/sidebar.ftl">

        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>
            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2><i class="fa fa-user"></i> Utenza di Tipo Tirocinanti</h2>
            <#if WarningSucess??>
                <#if WarningSuccess??>
                    <div class="alert alert-success mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${WarningSuccess}
                    </div>
                </#if>
            </#if>
            <#if WarningInsuccess??>
                <#if WarningInsuccess??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${WarningInsuccess}
                    </div>
                </#if>
            </#if>
            <h3>Lista Tirocinanti</h3>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Tirocinanti
                </div>
                <div class="card-body">
                    <div class="table-responsive" >
                        <table class="table table-striped table-bordered table-hover" id="datatable_tirocinante" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Cognome</th>
                                <th>Codice Fiscale</th>
                                <th>Data Di Nascita</th>
                                <th>Telefono</th>
                                <th>Portatore Handicap</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome</th>
                                <th>Cognome</th>
                                <th>Codice Fiscale</th>
                                <th>Data Di Nascita</th>
                                <th>Telefono</th>
                                <th>Portatore Handicap</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#list tirocinanti as tirocinante>
                            <tr>
                                <td>${tirocinante.nome}</td>
                                <td>${tirocinante.cognome}</td>
                                <td>${tirocinante.codiceFiscale}</td>
                                <td>${tirocinante.dataDiNascita}</td>
                                <td>${tirocinante.telefono}</td>
                                <td><#if tirocinante.handicap>yes<#else>no</#if> </td>
                                <td>
                                    <form action="/show-tirocinante" method="post">
                                        <input type="hidden" name="ID" value="${tirocinante.IDTirocinante}">
                                        <button type="submit" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                            Utente
                                        </button>
                                    </form>

                                </td>
                                <td>

                                        <a type="button" href="/modifica-tirociante?IDTirocinante=${tirocinante.IDTirocinante}" class="btn btn-secondary"><i
                                                    class="fa fa-pencil-square-o"></i>
                                            Modifica
                                        </a>
                                </td>

                                <td>
                                    <a type="button" href="#" class="btn btn-danger">
                                        <i class="fa fa-times"></i>
                                        Elimina
                                    </a>
                                </td>
                            </tr>
                            </#list>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>

            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2><i class="fa fa-industry fs-25"></i> Utenza di Tipo Aziendale</h2>
            <h3>Lista Aziende</h3>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Aziende
                </div>
                <div class="card-body">
                        <table class="table table-striped table-bordered table-hover" id="datatable_azienda" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Codice Fiscale - P.IVA </th>
                                <th>Nome Rappresentante</th>
                                <th>Cognome Rappresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Codice Fiscale - P.IVA</th>
                                <th>Nome Rappresentante</th>
                                <th>Cognome Rappresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Visualizza</th>
                                <th>Modifica</th>
                                <th>Elimina</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#list aziende as azienda>
                            <tr>
                                <td>${azienda.ragioneSociale}</td>
                                <td>${azienda.CFiscalePIva}</td>
                                <td>${azienda.nomeLegaleRappresentante}</td>
                                <td>${azienda.cognomeLegaleRappresentante}</td>
                                <td>${azienda.nomeResponsabileConvenzione}</td>
                                <td>${azienda.cognomeResponsabileConvenzione}</td>
                                <td>${azienda.emailResponsabileConvenzione}</td>
                                <td>
                                    <form action="/show-azienda" method="post">
                                        <input type="hidden" name="ID" value="${azienda.IDAzienda}">
                                        <button type="submit" class="btn btn-success"><i class="fa fa-file-text"></i>
                                            Visualizza Utente
                                        </button>
                                    </form>

                                </td>
                                <td>
                                  <form action="/modifica-azienda" method="get">
                                      <input type="hidden" name="ID"  value="${azienda.IDAzienda}">
                                      <button type="submit" class="btn btn-secondary">
                                          <i class="fa fa-pencil-square-o"></i>
                                            Modifica
                                        </button>
                                    </form>
                                </td>
                                <td>
                                    <a type="button" class="btn btn-danger"> Elimina</a>
                                </td>
                            </tr>
                            </#list>

                            </tbody>
                        </table>
                        <footer class="text-center text-sm-right mt-25 ">
                        </footer>
                </div>
            </div>

            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2><i class="fa fa-graduation-cap"></i> Utenza di Tipo Tutori Universitari</h2>
            <h3 class="mb-10">Crea Utente Turore Universitario</h3>
            <form id="form_crea_tutore_uni" method="post" action="/create-tutore" class="sky-form validate"
                  novalidate="novalidate">
                <#if ErroreNomeTutore??>
                    <div class="alert alert-warning mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreNomeTutore}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em> Nome</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="text" <#if ErroreNomeTutore??> class="error" </#if> placeholder="Nome" name="Nome_tutore" <#if ValueOfNome_tutore??> value="${ValueOfNome_tutore}" </#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri</b>
                </label>
                <#if ErroreCognomeTutore??>
                    <div class="alert alert-warning mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreCognomeTutore}
                    </div>
                </#if>
                <label class="input mb-20">
                    <p><em>*</em> Cognome</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="text" <#if ErroreCognomeTutore??> class="error" </#if> placeholder="Cognome" name="Cognome_tutore" <#if ValueOfCognome_tutore??> value="${ValueOfCognome_tutore}" </#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri</b>
                </label>
                <#if ErroreTelefonoTutore??>
                    <div class="alert alert-warning mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreTelefonoTutore}
                    </div>
                </#if>
                <label class="input mb-20">
                    <p><em>*</em> Numero di Telefono</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="tel"  <#if ErroreTelefonoTutore??> class="error" </#if> placeholder="Numero di Telefono" name="Numero_telefono_tutore"  <#if ValueOfNumero_telefono_tutore??> value="${ValueOfNumero_telefono_tutore}" </#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo numeri</b>
                </label>
                <#if ErroreEmailTutore??>
                    <div class="alert alert-warning mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreEmailTutore}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em> Indirizzo Email</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="email" <#if ErroreEmailTutore??> class="error" </#if> placeholder="Indirizzo Email" name="Email_tutore" <#if ValueOfEmail_tutore??> value="${ValueOfEmail_tutore}" </#if> required>
                    <b class="tooltip tooltip-bottom-right">Necessario per essere contattato</b>
                </label>

                <footer class="text-center text-sm-right mt-25 ">
                    <button type="submit" form="form_crea_tutore_uni"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                class="fa fa-check"></i> Crea
                    </button>
                    <button type="reset" form="form_crea_tutore_uni"
                            class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>
            <h3>Lista Tutori Universitari</h3>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Turori Universitari
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered table-hover" id="datatable_tutore" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Telefono</th>
                            <th>Email</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Telefono</th>
                            <th>Email</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <#list tutori as tutore >

                            <tr>
                            <td>${tutore.nome}</td>
                            <td>${tutore.cognome}</td>
                            <td>${tutore.telefono}</td>
                            <td>${tutore.email}</td>

                            <td>
                                <form action="/modifica-tutore" method="get">

                                <input type="hidden" name="IDTutoreUni" value="${tutore.IDTutoreUni}">
                                    <button type="submit" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica
                                    </button>
                                </form>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina Utente
                                </button>
                            </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>


            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2><i class="fa fa-user-md"></i> Utenza di Tipo Amministratore</h2>
            <h3 class="mb-10">Crea Utente Aministratore</h3>
            <form id="form_crea_admin" method="post" action="/creaadmin" class="sky-form validate"
                  novalidate="novalidate">

                <#if ErroreEmail??>
                    <div class="alert alert-warning mb-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione!</strong> ${ErroreEmail}
                    </div>
                    </#if>
                <label class="input">
                    <p><em>*</em> Indirizzo Email</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="text"  <#if ErroreEmail??> class="error" </#if> placeholder="Indirizzo Email" name="Email" <#if ValueOfEmail??>value="${ValueOfEmail}"</#if> required>
                    <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
                </label>


                    <#if ErrorePassword??>
                        <div class="alert alert-warning mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErrorePassword}
                        </div>
                    </#if>
                <label class="input">
                    <p><em>*</em> Password</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="password" <#if ErrorePassword??> class="error" </#if> placeholder="Password"  name="Password" <#if ValueOfPassword??>value="${ValueOfPassword}" </#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>
                <#if ErroreConfermaPassword??>
                    <div class="alert alert-warning mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreConfermaPassword}
                    </div>
                </#if>
                <label class="input mb-20">

                    <p><em>*</em> Password</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="password" <#if ErrorePassword??> class="error" </#if> placeholder="Conferma password"   name="ConfermaPassword" <#if ValueOfConfermaPassword??> value="${ValueOfConfermaPassword}" </#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>

                    <#if ErroreNome??>
                        <div class="alert alert-warning mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreNome}
                        </div>
                    </#if>
                <label class="input">
                    <p><em>*</em> Nome</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="text" <#if ValueofNome??>class="error"</#if> placeholder="Nome" name="Nome" <#if ValueofNome??>value="${ValueofNome}"  </#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>
                <#if ErroreCognome??>
                    <div class="alert alert-warning mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreCognome}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em>Cognome</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="text" <#if ValueOfCognome??>class="error"</#if> placeholder="Cognome" name="Cognome" <#if ValueOfCognome??> value="${ValueOfCognome}"</#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>

                <footer class="text-center text-sm-right mt-25 ">
                    <button type="submit" form="form_crea_admin"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                class="fa fa-check"></i> Crea
                    </button>
                    <button type="reset" form="form_crea_admin"
                            class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>
            <h3>Lista Aministratori</h3>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Amministratori
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered table-hover" id="datatable_amministatori" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Modifica</th>
                            <th>Elimina</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <#list listadmin as admin >
                        <tr>

                            <td>${admin.nome}</td>
                            <td>${admin.cognome}</td>
                            <td>
                                <form action="/modifica-admin" method="get">
                                    <input type="hidden" value="${admin.IDadmin}" name="ID" >
                                    <button type="submit" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica
                                    </button>
                                </form>
                            </td>
                            <td>
                                <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina Utente
                                </button>
                            </td>
                        </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>
</div>


<#include "../importScript.ftl">

<!-- Script page -->
<script src="../../plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.js"></script>
<script src="../../plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTableTirocinanti() {

        var table = jQuery('#datatable_tirocinante');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [0, 'asc'],
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableAziende() {

        var table = jQuery('#datatable_azienda');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [0, 'asc'],
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    function initTableAdmin() {

        var table = jQuery('#datatable_amministatori');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [0, 'asc'],
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Filtra i record:",
                "emptyTable": "Nessun dato disponibile nella tabella",
                "zeroRecords": "Nessuna corrispondenza trovata",
                "info": "Mostra da _START_ a _END_ di _TOTAL_ voci",
                "infoEmpty": "Nessuna voce da mostrare",
                "infoFiltered": " (filtrato da _MAX_ voci totali)"
            },
            "pageLength": 5, // set the initial value,
            "columnDefs": [{  // set default column settings
                'orderable': true,
                'targets': [0]
            }, {
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }
    initTableTirocinanti();
    initTableAziende();
    initTableAdmin();

</script>

</body>
</html>
