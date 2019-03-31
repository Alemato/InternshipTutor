<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Moduli</title>

    <!-- mobile settings -->
    <meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0"/>
    <!--[if IE]>
    <meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

    <!-- WEB FONTS : use %7C instead of | (pipe) -->
    <link href="https://fonts.googleapis.com/css?family=Material+Icons%7COpen+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"
          rel="stylesheet" type="text/css"/>

    <!-- CORE CSS -->
    <link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

    <!-- THEME CSS -->
    <link href="css/essentials.css" rel="stylesheet" type="text/css"/>
    <link href="css/layout.css" rel="stylesheet" type="text/css"/>

    <!-- PAGE LEVEL SCRIPTS -->
    <link href="css/header-1.css" rel="stylesheet" type="text/css"/>
    <link href="css/blue.css" rel="stylesheet" type="text/css" id="color_scheme"/>
    <link href="css/internshiptutor.css" rel="stylesheet" type="text/css">

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
        <li class=""><a href="admin.html">HOME DASHBOARD</a></li>
        <li class="active"><a href="gestione-moduli-admin.html"><b>GESTIONE MODULI</b></a></li>
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

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2>Convenzioni</h2>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Moduli di Richiesta di Convenzionamento Aziendale
                </div>
                <#--Moduli di convenzionamento gia stipulati-->
                <div class="card-body">
                        <table class="table table-responsive table-striped table-bordered table-hover"
                               id="datatable_ric_convenzioni" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Ente/Azienda</th>
                                <th>Sede Legale</th>
                                <th>Codice Fiscale Tirocinante</th>
                                <th>Nome Tutore Aziendale</th>
                                <th>Cognome Tutore Aziendale</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Richiesta</th>
                                <th>Visualizza PDF Richiesta</th>
                                <th>Invalida PDF</th>


                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Ente/Azienda</th>
                                <th>Sede Legale</th>
                                <th>Codice Fiscale Tirocinante</th>
                                <th>Nome Tutore Aziendale</th>
                                <th>Cognome Tutore Aziendale</th>
                                <th>Data Richiesta</th>
                                <th>Visualizza Richiesta</th>
                                <th>Visualizza PDF Richiesta</th>
                                <th>Invalida PDF</th>

                            </tr>
                            </tfoot>
                            <tbody>

                            <#if Aziende?has_content>


                           <#list Aziende as azienda >
                            <tr>
                                <td>${azienda.ragioneSociale}</td>
                                <td>${azienda.indirizzoSedeLegale}</td>
                                <td>${azienda.CFiscalePIva}</td>
                                <td>${azienda.nomeResponsabileConvenzione}</td>
                                <td>${azienda.cognomeResponsabileConvenzione}</td>
                                <td>${azienda.dataConvenzione?date?string("dd-MM-yyyy")}</td>
                                <td>
                                    <#if (azienda.pathPDFConvenzione)??>
                                        <a type="button" class="btn btn-success" href="/convezione-azienda?IDAzienda=${azienda.IDAzienda} "> <i class="fa fa-file-text"></i> Visualizza</a>
                                        <#else>
                                            <button type="button" class="btn btn-success" disabled> <i class="fa fa-file-text"></i> Non disponibile</button>
                                    </#if>

                                </td>
                                <td>
                                    <#--TODO Metti i link non appena pronti-->
                                    <#if (azienda.pathPDFConvenzione)??>
                                        <a type="button" class="btn btn-primary"  href="/"> <i class="fa fa-file-pdf-o"></i>Visualizza PDF</a>
                                        <#else>
                                            <button class="btn btn-primary" disabled> <i class="fa fa-file-pdf-o"></i> PDF Non Presente</button>
                                    </#if>

                                </td>
                                <td>
                               <#if (azienda.pathPDFConvenzione)??>
                                    <a type="button" href="/invalida-convenzione?IDAzienda=${azienda.IDAzienda}" class="btn btn-danger"> Invalida</a>
                               <#else>
                                   <button class="btn btn-danger" disabled> Non Diponibile</button>
                               </#if>
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
<script>var plugin_path = 'plugins/';</script>
<script src="plugins/jquery/jquery-3.3.1.min.js"></script>
<script src="js/scripts.js"></script>
<script src="plugins/bootstrap/js/bootstrap.js"></script>


<!-- Script page -->
<script src="plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="plugins/datatables/dataTables.bootstrap.js"></script>
<script src="plugins/select2/js/select2.full.min.js"></script>
<script>
    // datatable_ric_convenzioni
    // datatable_fine_tirocinio
    function initTableRicTiro() {

        var table = jQuery('#datatable_ric_tiro');

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
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc'],
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

    function initTableRicConvenzioni() {

        var table = jQuery('#datatable_ric_convenzioni');

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
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [7, 'asc'],
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

    function initTableFineTirocinio() {

        var table = jQuery('#datatable_fine_tirocinio');

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
                "orderable": true
            }, {
                "orderable": false
            },{
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": false
            }],
            "order": [
                [14, 'asc'],
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

    initTableRicTiro();
    initTableRicConvenzioni();
    initTableFineTirocinio();

</script>
</body>
</html>
