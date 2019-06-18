<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista Convenzioni</title>
    <#include "importCss.ftl">

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class="enable-animation">

<div id="wrapper">
    <#include "header.ftl">

    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>LISTA CONVENZIONI </h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/home">Home</a></li>
                <li>Lista Convenzioni</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <!-- SECTION CENTER -->
    <section class="section-sm centrale border-top-section">
        <div class="container">
            <h2 class="fw-100">Aziende convenzionate per stage e tirocini</h2>

            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover" id="datatable_lista_convenzioni"
                       width="100%"
                       cellspacing="0">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Localit&agrave;</th>
                        <th>Sito Web</th>
                        <th>Data Convenzione</th>
                    </tr>
                    </thead>

                    <tfoot>
                    <tr>
                        <th>Nome</th>
                        <th>Localit&agrave;</th>
                        <th>Sito Web</th>
                        <th>Data Convenzione</th>
                    </tr>
                    </tfoot>

                    <tbody>
                    <#list ListaConv as listaConvenzione>
                    <tr>
                        <td><a href="/schedaazienda?ID=${listaConvenzione.IDAzienda}">${listaConvenzione.ragioneSociale}</a></td>
                        <td>${listaConvenzione.indirizzoSedeLegale}</td>
                        <td><a <#if listaConvenzione.link??>href="${listaConvenzione.link}</#if>">${listaConvenzione.ragioneSociale}</a></td>
                        <td>${listaConvenzione.dataConvenzione}</td>
                    </tr>
                    </#list>

                    </tbody>
                </table>
            </div>
        </div>
    </section>

    <!-- /FOOTER-->
    <#include "footer.ftl">

</div>

<!-- JAVASCRIPT FILES -->
<#include "importScript.ftl">
<!-- Script page -->
<script src="/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="/plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="/plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="/plugins/select2/js/select2.full.min.js"></script>
<script>
    function initTableListaConvenzioni() {

        var table = jQuery('#datatable_lista_convenzioni');

        var oTable = table.dataTable({
            "columns": [{
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }, {
                "orderable": true
            }],
            "order": [
                [0, 'asc']
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
            }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }
    initTableListaConvenzioni();
</script>
</body>
</html>