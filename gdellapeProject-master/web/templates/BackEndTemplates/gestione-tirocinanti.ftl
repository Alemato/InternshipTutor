<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Tirocinanti</title>

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
        <li class="active"><a href="#"><b>GESTIONE TIROCINANTI</b></a></li>
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
                    <p>Per motivi di usabilit&agrave; &egrave; sconsigliato l&apos;uso dei <b>javascript</b>, per tanto
                        <b>attiva tale funzionalit&agrave; nel tuo browser!!!</b></p>
                </div>
            </noscript>
            <h2><i class="fa fa-user"></i> Gestione Tirocinanti</h2>
            <section class="row text-center placeholders pt-10 mb-10">
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
            <div class="card">
                <div class="card-header">
                    <i class="fa fa-table"></i> Tirocinanti
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover" id="datatable_tirocinante"
                               width="100%"
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
                                <th>Cambia Email</th>
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
                                <th>Cambia Email</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <#list tirocinanti as tirocinante>
                                <tr>
                                    <td>${tirocinante.nome}</td>
                                    <td>${tirocinante.cognome}</td>
                                    <td>${tirocinante.codiceFiscale}</td>
                                    <td>${tirocinante.dataDiNascita?date?string("dd-MM-yyyy")}</td>
                                    <td>${tirocinante.telefono}</td>
                                    <td><#if tirocinante.handicap>yes<#else>no</#if> </td>
                                    <td>
                                        <a type="button" class="btn btn-primary"
                                           href="/admin/show-tirocinante?IDTirocinante=${tirocinante.IDTirocinante}">
                                            <i class="fa fa-file-text"></i>Visualizza Utente
                                        </a>
                                    </td>
                                    <td>
                                        <a type="button" href="/admin/reimposta-user?IDUser=${tirocinante.user}"
                                           class="btn btn-secondary">
                                            <i class="fa fa-pencil-square-o"></i>Cambia</a>
                                    </td>

                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
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
                "orderable": false
            }, {
                "orderable": false
            }
            ],
            "order": [
                [0, 'asc']
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
            }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }


    initTableTirocinanti();


</script>

</body>
</html>
