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
        <#include "../BackEndTemplates/sidebar.ftl">


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto
                        <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <#if WarningSuccess??>
                <div class="alert alert-success mb-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione!</strong> ${WarningSuccess}
                </div>
            </#if>
            <#if WarningInsuccess??>
                <div class="alert alert-danger mb-20">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione!</strong> ${WarningInsuccess}
                </div>
            </#if>
            <h2>OFFERTE DI TIROCINIO DISPONIBILI</h2>
            <table class="table table-responsive table-striped table-bordered table-hover" id="datatable_offerte_attive"
                   width="100%"
                   cellspacing="0">
                <thead>
                <tr>
                    <th>Codice Identificativo</th>
                    <th>Titolo</th>
                    <th>Azienda Ospitante</th>
                    <th>Nome Tutore Aziendale</th>
                    <th>Cognome Tutore Aziendale</th>
                    <th>Tel. Tutore Aziendale</th>
                    <th>Email Tutore Aziendale</th>
                    <th>Data Creazione</th>
                    <th>Visualizza</th>
                    <th>Disattiva</th>
                    <th>Visualizza Utenti Richiedenti</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Codice Identificativo</th>
                    <th>Titolo</th>
                    <th>Azienda Ospitante</th>
                    <th>Nome Tutore Aziendale</th>
                    <th>Cognome Tutore Aziendale</th>
                    <th>Tel. Tutore Aziendale</th>
                    <th>Email Tutore Aziendale</th>
                    <th>Data Creazione</th>
                    <th>Visualizza</th>
                    <th>Disattiva</th>
                    <th>Visualizza Utenti Richiedenti</th>
                </tr>
                </tfoot>
                <tbody>
                <#if OfferteAttive?has_content>
                <#list OfferteAttive as offerta>
                <tr>
                    <td>${offerta.codIdentTirocinio}</td>
                    <td>${offerta.titolo}</td>
                    <td>${offerta.aziendaOspitante}</td>
                    <td>${offerta.nomeTutoreAziendale}</td>
                    <td>${offerta.cognomeTutoreAziendale}</td>
                    <td>${offerta.telefonoTutoreAziendale}</td>
                    <td>${offerta.emailTutoreAziendale}</td>
                    <td>${offerta.createDate?date?string("dd-MM-yyyy")}</td>
                    <td>
                        <a type="button" class="btn btn-primary" href="/show-offerta?IDOfferta=${offerta.IDOffertaTirocinio}"><i class="fa fa-file-text"></i>Visualizza</a>

                    </td>
                    <td>
                            <a type="button" class="btn btn-danger" href="/disattiva-offerta?IDOfferta=${offerta.IDOffertaTirocinio}"><i class="fa fa-times"></i>Disattiva</a>

                    </td>
                    <td>
                            <a type="button" class="btn btn-primary" href="/show-richiedenti?IDOfferta=${offerta.IDOffertaTirocinio}"><i class="fa fa-users"></i>Visualizza Utenti
                                Richiedenti
                            </a>

                    </td>
                </tr>
                </#list>
                </#if>

                </tbody>
            </table>


            <div class="card" id="offerte_scadute">
                <div class="card-header">
                    <h2>OFFERTE DI TIROCINIO SCADUTE</h2>
                </div>
                <div class="card-body">
            <table class="table table-responsive table-striped table-bordered table-hover" id="datatable_offerte_disattive"
                   width="100%"
                   cellspacing="0">
                <thead>
                <tr>
                    <th>Codice Identificativo</th>
                    <th>Titolo</th>
                    <th>Azienda Ospitante</th>
                    <th>Nome Tutore Aziendale</th>
                    <th>Cognome Tutore Aziendale</th>
                    <th>Tel. Tutore Aziendale</th>
                    <th>Email Tutore Aziendale</th>
                    <th>Data Creazione</th>
                    <th>Visualizza</th>
                    <th>Visualizza Utenti Richiedenti</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Codice Identificativo</th>
                    <th>Titolo</th>
                    <th>Azienda Ospitante</th>
                    <th>Nome Tutore Aziendale</th>
                    <th>Cognome Tutore Aziendale</th>
                    <th>Tel. Tutore Aziendale</th>
                    <th>Email Tutore Aziendale</th>
                    <th>Data Creazione</th>
                    <th>Visualizza</th>
                    <th>Visualizza Utenti Richiedenti</th>
                </tr>
                </tfoot>
                <tbody>
                <#if OfferteScadute?has_content>
                <#list OfferteScadute as offerta>
                    <tr>
                        <td>${offerta.codIdentTirocinio}</td>
                        <td>${offerta.titolo}</td>
                        <td>${offerta.aziendaOspitante}</td>
                        <td>${offerta.nomeTutoreAziendale}</td>
                        <td>${offerta.cognomeTutoreAziendale}</td>
                        <td>${offerta.telefonoTutoreAziendale}</td>
                        <td>${offerta.emailTutoreAziendale}</td>
                        <td>${offerta.createDate?date?string("dd-MM-yyyy")}</td>
                        <td>
                            <a type="button" class="btn btn-primary" href="/Show-Offerta?IDOfferta=${offerta.IDOffertaTirocinio}"><i class="fa fa-file-text"></i>Visualizza</a>

                        </td>
                        <td>
                                <a type="button" class="btn btn-primary" href="/show-richiedenti?IDOfferta=${offerta.IDOffertaTirocinio}"><i class="fa fa-users"></i>Visualizza Utenti
                                    Richiedenti
                                </a>
                        </td>
                    </tr>
                </#list>
                </#if>

                </tbody>
            </table>
                </div>
            </div>
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
    function initTableOfferteAttive() {

        var table = jQuery('#datatable_offerte_attive');

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
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [1, 'asc'],
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
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
    function initTableOfferteDisative() {

        var table = jQuery('#datatable_offerte_disattive');

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
                "orderable": true
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [1, 'asc'],
            ],
            "lengthMenu": [
                [5, 10, 20, -1],
                [5, 10, 20, "Tutti"] // change per page values here
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

    initTableOfferteAttive();
    initTableOfferteDisative()
</script>

</body>
</html>
