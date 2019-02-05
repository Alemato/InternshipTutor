<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

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
        <li class="active"><a href="admin.html"><b>HOME DASHBOARD</b></a></li>
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
            <h2>Richieste di Convenzioni Aziendali</h2>
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Richieste di Convenzionamento pendenti
                </div>
                <div class="card-body">
                    <div class="table-responsive">

                        <table class="table table-striped table-bordered table-hover" id="datatable_1" width="100%"
                               cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Sede Legale</th>
                                <th>Codice Fiscale</th>
                                <th>Nome Rapresentante</th>
                                <th>Cognome Rapresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Tel. Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Data Richiesta</th>
                                <th>Carica PDF e accetta </th>
                                <th>Declina richiesta</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Nome Ente</th>
                                <th>Sede Legale</th>
                                <th>Codice Fiscale</th>
                                <th>Nome Rapresentante</th>
                                <th>Cognome Rapresentante</th>
                                <th>Nome Responsabile</th>
                                <th>Cognome Responsabile</th>
                                <th>Tel. Responsabile</th>
                                <th>Email Responsabile</th>
                                <th>Data Richiesta</th>
                                <th>Carica PDF e accetta </th>
                                <th>Declina richiesta</th>
                            </tr>
                            </tfoot>
                            <tbody>

                            <#list aziende as azienda>
                                <tr>

                                    <td>${azienda.ragioneSociale}</td>
                                    <td>${azienda.indirizzoSedeLegale}</td>
                                    <td>${azienda.CFiscalePIva}</td>
                                    <td>${azienda.nomeLegaleRappresentante}</td>
                                    <td>${azienda.cognomeLegaleRappresentante}</td>
                                    <td>${azienda.nomeResponsabileConvenzione}</td>
                                    <td>${azienda.cognomeResponsabileConvenzione}</td>
                                    <td>${azienda.telefonoResponsabileConvenzione}</td>
                                    <td>${azienda.emailResponsabileConvenzione}</td>

                                    <td>${azienda.dataConvenzione}</td>

                                    <td>

                                        <form action="/Accetta"  method="post" enctype="multipart/form-data">
                                            <input type="file"  name="pdf" id="filetoupload">
                                            <input type="hidden" name="stato" value="1">
                                            <input type="hidden" name="nome" value="${azienda.ragioneSociale}">
                                            <input  type="submit" class="btn btn-green" value="Accetta">
                                        </form>
                                    </td>
                                    <td>
                                        <form action="#" method="post">
                                            <input type="hidden" name="state" value="0">
                                            <input type="hidden" name="nome" value="${azienda.ragioneSociale}">
                                            <input  type="submit" class="btn btn-red" value="Declina">
                                        </form>

                                    </td>
                                </tr>
                            </#list>

                            </tbody>
                        </table>

                        <footer class="text-center text-sm-right mt-25 ">

                            <button type="submit" form="form_rispondi"
                                    class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                        class="fa fa-check"></i> Aggiorna
                            </button>
                            <button type="reset" form="form_rispondi"
                                    class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                        class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </div>
                </div>
            </div>

            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <h2>Ultime offerte tirocinio publicate</h2>
            <!-- Richieste di tirocinio accettate -->
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> offerte tirocinio publicate
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered table-hover" id="datatable_2" width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Titolo Tirocinio</th>
                            <th>Nome Ente</th>
                            <th>Descrizione</th>
                            <th>Luogo di Svolgimento</th>
                            <th>Modalità di Svolgimento</th>
                            <th>Visualizza</th>
                            <th>Modifica</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Titolo Tirocinio</th>
                            <th>Nome Ente</th>
                            <th>Descrizione</th>
                            <th>Luogo di Svolgimento</th>
                            <th>Modalità di Svolgimento</th>
                            <th>Visualizza</th>
                            <th>Modifica</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <tr>
                            <td>Tiger</td>
                            <td>Nixon</td>
                            <td>Edinburgh</td>
                            <td>2011/04/25</td>
                            <td>Tirocinio in corso</td>
                            <td>
                                <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                    Offerta
                                </button>
                            </td>
                            <td><a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>
                                        Modifica Offerta
                                    </button>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>Garrett</td>
                            <td>Winters</td>
                            <td>Tokyo</td>
                            <td>63</td>
                            <td>Concluso il 2011/07/25</td>
                            <td><a href="print.php">
                                    <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        Offerta
                                    </button>
                                </a>
                            </td>
                            <td><a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>Modifica Offerta
                                    </button>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>Ashton</td>
                            <td>Cox</td>
                            <td>San Francisco</td>
                            <td>66</td>
                            <td>Concluso il 2009/01/12</td>
                            <td><a href="print.php">
                                    <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                                        Offerta
                                    </button>
                                </a>
                            </td>
                            <td><a href="print.php">
                                    <button type="button" class="btn btn-secondary"><i
                                                class="fa fa-pencil-square-o"></i>Modifica Offerta
                                    </button>
                                </a>
                            </td>
                        </tr>
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
    function initTablePendenti() {

        var table = jQuery('#datatable_1');

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
                "width": "7%",
                "orderable": false
            }, {
                "width": "7%",
                "orderable": false
            }],
            "order": [
                [9, 'desc'],
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

    function initTableUltime() {

        var table = jQuery('#datatable_2');

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
            }],
            "order": [
                [0, 'asc'],
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

    initTablePendenti();
    initTableUltime();
    $("tr td input[type=checkbox]").click(enable_cb);


    function enable_cb() {
        if (this.checked) {
            console.log(this);
            $(this).closest("tr").children().children().attr("disabled", "true").addClass('grey');
            $(this).removeAttr("disabled").next().removeClass('grey');

        } else {
            $(this).closest("tr").children().children().removeAttr("disabled");
            $(this).closest("tr").children().children().removeClass('grey');
        }
    }
</script>

</body>
</html>
