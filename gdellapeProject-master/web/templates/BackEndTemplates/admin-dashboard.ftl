<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>

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
    <a class="navbar-brand link-bar" href="/home">Intership Tutor </a>
    <ol class="breadcrumb">
        <li class="active"><a href="#"><b>HOME DASHBOARD</b></a></li>
    </ol>
    <#include "small-navbar.ftl">

</nav>
<div class="container-fluid">
    <div class="row">
       <#include "sidebar.ftl">


        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">

            <noscript>
                <div class="alert alert-danger mb-10 mt-10">
                    <h3 class="mb-10"><strong>Attenzione!</strong></h3>
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>
            <h1>DASHBOARD</h1>

                <div class="row">
                    <div class="col-md-3 col-lg-3">
                        <div class="card bg-primary">
                            <div class="card-header">
                                <div class="card-title"><h5 class="text-white"><i class="fa fa-user"></i>&nbsp;Tirocini In Corso</h5></div>
                            </div>
                            <div class="card-body">
                                <div class="card-text mx-auto"><h2 class="text-white"> ${TirociniAttivi}</h2></div>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-3 col-lg-3">
                        <div class="card bg-success">
                            <div class="card-header">
                                <div class="card-title"><h5 class="text-white"><i class="fa fa-industry"></i>&nbsp;Aziende Convenzionate</h5></div>
                            </div>
                            <div class="card-body">
                                <div class="card-text mx-auto"><h2 class="text-white"> ${AziendeConven}</h2></div>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-3 col-lg-3">
                        <div class="card bg-secondary">
                            <div class="card-header">
                                <div class="card-title"><h5 class="text-white"><i class="fa fa-user"></i>&nbsp;Numero Tutori Universitari </h5></div>
                            </div>
                            <div class="card-body">
                                <div class="card-text mx-auto"><h2 class="text-white"> ${NTurori}</h2></div>
                            </div>

                        </div>
                    </div>
                        <div class="col-md-3 col-lg-3">
                            <div class="card bg-danger">
                                <div class="card-header">
                                    <div class="card-title"><h5 class="text-white"><i class="fa fa-book"></i>&nbsp;Offerte Di Tirocinio Rifiutate</h5></div>
                                </div>
                                <div class="card-body">
                                   <div class="card-text mx-auto"><h2 class="text-white">${TirociniRF} </h2></div>
                                </div>

                            </div>
                        </div>
                </div>
            <div class="row">
                <div class="col-md-6 col-lg-6">
                    <div class="card mb-50">
                        <div class="card-header">
                            <i class="fa fa-industry"></i> Classifica Aziende con i voti migliori
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-bordered table-hover" id="datatable_aziende_cla" width="100%"
                                   cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Nome</th>
                                    <th>Numero di votazioni</th>
                                    <th>Media Voti</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Nome</th>
                                    <th>Numero di votazioni</th>
                                    <th>Media Voti</th>

                                </tr>
                                </tfoot>
                                <tbody>
                                <#list Aziende as aziende >
                                    <tr>

                                        <td>${aziende.ragioneSociale}</td>
                                        <td>${aziende.voti}</td>
                                        <td>${aziende.valutazione}</td>

                                    </tr>
                                </#list>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 col-lg-6">
                    <div class="card mb-50">
                        <div class="card-header">
                            <i class="fa fa-industry"></i> Classifica dei tutori universitari pi&uacute; richiesti
                        </div>
                        <div class="card-body">
                            <table class="table table-striped table-bordered table-hover" id="datatable_tutore_cla" width="100%"
                                   cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Nome e cognome</th>
                                    <th>Numero di tirocinanti</th>
                                </tr>
                                </thead>
                                <tfoot>
                                <tr>
                                    <th>Nome</th>
                                    <th>Numero di tirocinanti</th>

                                </tr>
                                </tfoot>
                                <tbody>
                                <#list Tutori as tutore,numero >
                                    <tr>

                                        <td>${tutore.nome}&nbsp;${tutore.cognome}</td>
                                        <td>${numero}</td>

                                    </tr>
                                </#list>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>




        </main>
    </div>
</div>


<!-- JAVASCRIPT FILES -->
<#include "../importScript.ftl">
<!-- Script page -->
<!-- Script page -->
<script src="../../plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="../../plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="../../plugins/datatables/dataTables.bootstrap.js"></script>
<script src="../../plugins/select2/js/select2.full.min.js"></script>
<script>


    function initTableAziendeCla() {

        var table = jQuery('#datatable_aziende_cla');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": true
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
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }
    function initTableTutoriCla() {

        var table = jQuery('#datatable_tutore_cla');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": false
            }, {
                "orderable": true
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
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    initTableAziendeCla();
    initTableTutoriCla();

</script>

</body>
</html>
