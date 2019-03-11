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

            <section class="row text-center placeholders pt-10 pb-10 mb-10">
            </section>
            <h2>Tutte le Offete di Tirocinio</h2>

            <table class="table table-responsive table-striped table-bordered table-hover" id="datatable_all"
                   width="100%"
                   cellspacing="0">
                <thead>
                <tr>
                    <th>Codice Identificativo</th>
                    <th>Titolo</th>
                    <th>Nome Tutore Aziendale</th>
                    <th>Cognome Tutore Aziendale</th>
                    <th>Tel. Tutore Aziendale</th>
                    <th>Email Tutore Aziendale</th>
                    <th>Nome Tutore Universitarioe</th>
                    <th>Cognome Tutore Universitario</th>
                    <th>Tel. Tutore Universitario</th>
                    <th>Email Tutore Universitario</th>
                    <th>Data Creazione</th>
                    <th>Visualizza</th>
                    <th>Modifica</th>
                    <th>Elimina</th>
                    <th>Visualizza Utenti Richiedenti</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Codice Identificativo</th>
                    <th>Titolo</th>
                    <th>Nome Tutore Aziendale</th>
                    <th>Cognome Tutore Aziendale</th>
                    <th>Tel. Tutore Aziendale</th>
                    <th>Email Tutore Aziendale</th>
                    <th>Nome Tutore Universitario</th>
                    <th>Cognome Tutore Universitario</th>
                    <th>Tel. Tutore Universitario</th>
                    <th>Email Tutore Universitario</th>
                    <th>Data Creazione</th>
                    <th>Visualizza</th>
                    <th>Modifica</th>
                    <th>Elimina</th>
                    <th>Visualizza Utenti Richiedenti</th>
                </tr>
                </tfoot>
                <tbody>
                <#list map as key,value>
                <tr>
                    <td>${key.codiceTirocinio}</td>
                    <td>${key.titolo}</td>
                    <td>${key.nomeTutoreAziendale}</td>
                    <td>${key.cognomeTutoreAziendale}</td>
                    <td>${key.telefonoTutoreAzindale}</td>
                    <td>${key.emailTutoreAziendale}</td>
                    <td>${value.nome}</td>
                    <td>${value.cognome}</td>
                    <td>${value.telefono}</td>
                    <td>${value.email}</td>
                    <td>${key.createDate}</td>
                    <td><a href="print.php">
                            <button type="button" class="btn btn-success"><i class="fa fa-file-text"></i>Visualizza
                            </button>
                        </a>
                    </td>
                    <td><form action="/modificaofferta" method="get">
                            <input type="hidden" value="${key.IDOffertaTirocinio}" name="ID">

                            <button type="submit" class="btn btn-secondary"><i
                                        class="fa fa-pencil-square-o"></i>Modifica
                            </button>
                        </form>
                    </td>
                    <td><a href="print.php">
                            <button type="button" class="btn btn-danger"><i class="fa fa-times"></i>Elimina
                            </button>
                        </a>
                    </td>
                    </td>
                    <td><a href="print.php">
                            <button type="button" class="btn btn-primary"><i class="fa fa-users"></i>Visualizza Utenti
                                Richiedenti
                            </button>
                        </a>
                    </td>
                </tr>
                </#list>

                </tbody>
            </table>

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
    function initTableAll() {

        var table = jQuery('#datatable_all');

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
                "orderable": false
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

    initTableAll();
</script>

</body>
</html>
