<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Gestione Richieste Tirocinio</title>
    <#include "importCss.ftl">
    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>
</head>
<body class=" enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('/imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>Gestione Richieste di Tirocinio</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li>Gestione Richieste</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section">
        <div class="container p-0">
            <#if Scaduto??>
            <#if !Scaduto>
            <#if errore??>
                <div class="alert alert-danger mb-30">
                    <button type="button" class="close" data-dismiss="alert">
                        <span aria-hidden="true">&times;</span>
                        <span class="sr-only">Chiudi</span>
                    </button>
                    <strong>Attenzione! </strong>${errore}
                </div>
            </#if>
                <#if StatoRic??>
                    <div class="alert alert-success mb-30">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione! </strong>${StatoRic}
                    </div>
                </#if>
            <h1 class="mb-0">Richieste Pendanti</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Visualizza Tutte le Richieste di Tirocinio pendenti
                </div>
                <div class="card-body">
                    <form id="form_tirocinii_fine" action="/account/gestione-richieste" method="post">
                        <table class="table table-striped table-bordered bg-white table-hover border"
                               id="datatable_1" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>Nome Offerta</th>
                                <th>Nome Tirocinante</th>
                                <th>Cognome Tirocinante</th>
                                <th>email Tirocinante</th>
                                <th>Accetta Richiesta</th>
                                <th>Rifiuta Richiesta</th>
                            </tr>
                            </thead>
                            <tbody id="checkbox">
                            <#list Lista as Lista1>
                                <#if Lista1.tirocinio.stato == 0>
                                    <tr>
                                        <td>
                                            <a href="/account/gestione-offerte/view?id=${Lista1.offerta.IDOffertaTirocinio}"
                                               class="text-blue">${Lista1.offerta.titolo}</a></td>
                                        <td>${Lista1.tirocinante.nome}</td>
                                        <td>${Lista1.tirocinante.cognome}</td>
                                        <td>${Lista1.userMail}</td>
                                        <td><input type="checkbox" class="checkboxes"
                                                   name="ac-${Lista1.tirocinante.IDTirocinante}-${Lista1.tirocinio.IDTirocinio}"
                                                   value="1"/> <i
                                                    class="fa fa-check" style="color: green;"></i> Accetta
                                        </td>
                                        <td><input type="checkbox" class="checkboxes"
                                                   name="de-${Lista1.tirocinante.IDTirocinante}-${Lista1.tirocinio.IDTirocinio}"
                                                   value="2"/> <i
                                                    class="fa fa-times" style="color: red;"></i> Declina
                                        </td>
                                    </tr>
                                </#if>
                            </#list>
                            </tbody>
                        </table>
                        <footer class="text-center text-sm-right mt-25 ">
                            <button type="submit" form="form_tirocinii_fine"
                                    class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                        class="fa fa-check"></i> Aggiorna
                            </button>
                            <button type="reset" form="form_tirocinii_fine"
                                    class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                        class="fa fa-times"></i> Annulla
                            </button>
                        </footer>
                    </form>
                </div>
            </div>
            </#if>
            </#if>
            <h1 class="mt-25 mb-0">Richieste Declinate</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Visualizza Tutte le Richieste declinate
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered bg-white table-hover border"
                           id="datatable_2" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome Offerta</th>
                            <th>Nome Tirocinante</th>
                            <th>Cognome Tirocinante</th>
                            <th>email Tirocinante</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list Lista as Lista2>
                            <#if Lista2.tirocinio.stato == 5>
                                <tr>
                                    <td><a href="/account/gestione-offerte/view?id=${Lista2.offerta.IDOffertaTirocinio}"
                                           class="text-blue">${Lista2.offerta.titolo}</a></td>
                                    <td>${Lista2.tirocinante.nome}</td>
                                    <td>${Lista2.tirocinante.cognome}</td>
                                    <td>${Lista2.userMail}</td>
                                </tr>
                            </#if>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </section>
    <#include "footer.ftl">
</div>
<#include "importScript.ftl">

<!-- Script page -->
<script src="/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="/plugins/datatables/js/dataTables.tableTools.min.js"></script>
<script src="/plugins/datatables/js/dataTables.colReorder.min.js"></script>
<script src="/plugins/datatables/js/dataTables.scroller.min.js"></script>
<script src="/plugins/datatables/dataTables.bootstrap.js"></script>
<script src="/plugins/select2/js/select2.full.min.js"></script>
<script>
    <#if Scaduto??>
    <#if !Scaduto>
    function initTableAll() {

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
                "orderable": false
            }, {
                "orderable": false
            }],
            "order": [
                [0, 'asc']
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
            "scrollX": true,
            "columnDefs": [  // set default column settings
                {
                    "searchable": true,
                    "targets": [0]
                }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }
    </#if>
    </#if>
    function initTableDeclinati() {

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
            }],
            "order": [
                [0, 'asc']
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
            "scrollX": true,
            "columnDefs": [  // set default column settings
                {
                    "searchable": true,
                    "targets": [0]
                }]
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }
    <#if Scaduto??>
    <#if !Scaduto>
    initTableAll();
    </#if>
    </#if>
    initTableDeclinati();
    <#if Scaduto??>
    <#if !Scaduto>
    $("tbody#checkbox tr td input[type=checkbox]").click(enable_cb);


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
    </#if>
    </#if>
</script>
</body>
</html>
