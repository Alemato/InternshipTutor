<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Moduli disponibili</title>


    <#include "importCss.ftl">

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('../imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>TIROCINI E MODULI</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li>Tirocini e Moduli</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <h1 class="mb-0">TIROCINI E MODULI</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <#--<form id="form_tirocinii_fine" action="/account/moduli" method="post">-->
            <table class="table table-responsive table-striped table-bordered bg-white table-hover border"
                   id="datatable_2" width="100%"
                   cellspacing="0">
                <thead>
                <tr>
                    <th>Azienda</th>
                    <th>Inizio</th>
                    <th>Fine</th>
                    <th>Tutore Aziendale</th>
                    <th>Tutore Universitario</th>
                    <th>Stato</th>
                    <th>Modulo Richiesta</th>
                    <th>Modulo Azienda</th>
                    <th>Modulo Segreteria</th>
                    <th>Tirocinio</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Azienda</th>
                    <th>Inizio</th>
                    <th>Fine</th>
                    <th>Tutore Aziendale</th>
                    <th>Tutore Universitario</th>
                    <th>Stato</th>
                    <th>Modulo Richiesta</th>
                    <th>Modulo Azienda</th>
                    <th>Modulo Segreteria</th>
                    <th>Tirocinio</th>
                </tr>
                </tfoot>

                <tbody>
                <#if nessunTirocinio??>
                <#else>
                <#list lista as lista>
                    <tr>
                        <td>${lista.offertaTirocinio.aziendaOspitante}</td>
                        <#if lista.tirocinio.periodoEffettivoIniziale??>
                            <td>${lista.tirocinio.periodoEffettivoIniziale}</td>
                        <#else>
                            <td>${lista.offertaTirocinio.periodoInizio}</td>
                        </#if>
                        <#if lista.tirocinio.periodoEffettivoFinale??>
                            <td>${lista.tirocinio.periodoEffettivoFinale}</td>
                        <#else>
                            <td>${lista.offertaTirocinio.periodoFine}</td>
                        </#if>
                        <td>${lista.offertaTirocinio.nomeTutoreAziendale} ${lista.offertaTirocinio.cognomeTutoreAziendale}</td>
                        <td>${lista.tutoreUniversitario.nome} ${lista.tutoreUniversitario.cognome}</td>
                        <#if lista.tirocinio.stato == 0>
                            <td>Richiesta Inoltrata</td>
                        <#elseif lista.tirocinio.stato == 1>
                            <td>Richiesta Accettata</td>
                        <#elseif lista.tirocinio.stato == 2>
                            <td>Periodo Tirocinio Terminato</td>
                        <#elseif lista.tirocinio.stato == 3 || lista.tirocinio.stato == 4>
                            <td>Tirocinio Concluso</td>
                        <#elseif lista.tirocinio.stato == 5>
                            <td>Tirocinio Rifiutato</td>
                        </#if>
                        <#if lista.tirocinio.pdfTirocinante?has_content>
                            <td>
                                <a href="/account/moduli/richiesta-tirocinio?id=${lista.tirocinio.IDTirocinio}">
                                    <button type="button" class="btn btn-outline-success"><i
                                                class="fa fa-print"></i>Visualizza
                                    </button>
                                </a>
                            </td>
                        <#else>
                            <#if lista.tirocinio.stato == 0>
                                <td>In attesa di approvazione del Tirocinio</td>
                            <#else>
                                <td>In attesa del caricamento del modulo</td>
                            </#if>
                        </#if>
                        <#if lista.tirocinio.pdfAzienda?has_content>
                            <td>
                                <a href="/account/moduli/tirocinio?id=${lista.tirocinio.IDTirocinio}">
                                    <button type="button" class="btn btn-outline-success"><i
                                                class="fa fa-print"></i>Visualizza
                                    </button>
                                </a>
                            </td>
                        <#else>
                            <td>In attesa di caricamento del Pdf da parte dell'Azienda</td>
                        </#if>
                        <#if lista.tirocinio.pdfSegreteria?has_content>
                            <td>
                                <a href="/account/moduli/segreteria?id=${lista.tirocinio.IDTirocinio}">
                                    <button type="button" class="btn btn-outline-success"><i
                                                class="fa fa-print"></i>Visualizza
                                    </button>
                                </a>
                            </td>
                        <#else>
                            <td>In attesa del caricamento del modulo da parte della Segreteria</td>
                        </#if>
                        <td>
                            <a href="/account/moduli/gestionetirocinioscelto?idTirocinio=${lista.tirocinio.IDTirocinio}">
                                <button type="button" class="btn btn-outline-success"><i
                                            class="fa fa-plus"></i>Dettagli
                                </button>
                            </a>
                        </td>
                    </tr>
                </#list>
                </#if>
                </tbody>
            </table>

    </section>

    <#include "footer.ftl">
</div>

<#include "importScript.ftl">

<!-- Script page -->
<script src="../plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="../plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="../plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="../plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="../plugins/datatables/dataTables.bootstrap.js"></script>
<script src="../plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTableAccettati() {

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
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [1, 'asc']
            ],
            "lengthMenu": [
                [5, 15, 20, -1],
                [5, 15, 20, "Tutti"] // change per page values here
            ],
            "language": {
                "search": "Cerca: ",
                "searchPlaceholder": "Filtra i record",
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

    initTableAccettati();
</script>
</body>
</html>