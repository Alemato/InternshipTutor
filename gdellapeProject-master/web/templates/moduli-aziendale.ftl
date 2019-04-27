<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>Moduli disponibili</title>


    <#include "importCss.ftl">

    <!-- CSS DATATABLES -->
    <link href="/css/layout-datatables.css" rel="stylesheet" type="text/css"/>

</head>
<body class=" enable-animation">
<!-- wrapper -->
<div id="wrapper">
    <#include "header.ftl">
    <section class="page-header page-header-md parallax parallax-3 mt-130"
             style="background-image:url('../imgs/imgpattern.jpg')">
        <div class="overlay dark-2"><!-- dark overlay [1 to 9 opacity] --></div>

        <div class="container">

            <h1>MODULI</h1>

            <!-- breadcrumbs -->
            <ol class="breadcrumb">
                <li><a href="/">Home</a></li>
                <li><a href="/account">Il Mio Account</a></li>
                <li>Moduli Disponibili</li>
            </ol><!-- /breadcrumbs -->

        </div>
    </section>

    <section class="section-sm centrale border-top-section pl-20 pr-20">
        <div class="container">
            <h1 class="mb-0">MODULO PER LA CONVENZIONE</h1>
            <div class="linea-divisione mt-15 mb-30"></div>
            <#if CreaConvenzione??>
                <div class="alert alert-warning mb-30">
                    <strong>Attenzione non hai creato una richiesta di convenzione!</strong>
                    <br> Per creare una richiesta <a href="/account/moduli/convenzione">clicca qui</a>
                </div>
                <#else>
                    <div class="table-responsive mb-30">
                        <table class="table table-bordered bg-white text-center border">
                            <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Tipologia</th>
                                <th>Data Convenzione</th>
                                <#if GiorniScadenza??>
                                    <th>Giorni alla scadenza</th>
                                </#if>
                                <th>Data Aggiornamento Convenzione</th>
                                <#if ConvenzioneScaduta??>
                                    <#if ConvenzioneScaduta>
                                        <th>Aggiorna richiesta</th>
                                    <#else>
                                        <#if EsistePdf>
                                        <th>Stampa Modulo</th>
                                        <#else>
                                            <th>Modifica Modulo</th>
                                            <th>Carica PDF</th>
                                        </#if>
                                    </#if>
                                <#else>
                                    <th>Crea Modulo</th>
                                </#if>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>CONVENZIONE PER LO SVOLGIMENTO DI ATTIVITA&apos; DI TIROCINIO E DI ORIENTAMENTO</td>
                                <td>CONVENZIONE</td>
                                <td>${DataConvenzione?date?string.short}</td>
                                <#if GiorniScadenza??>
                                    <td>${GiorniScadenza}</td>
                                </#if>
                                <td>${DataUpdate?date?string.short}</td>
                                <#if ConvenzioneScaduta??>
                                    <#if ConvenzioneScaduta>
                                        <td>
                                            <a href="/account/moduli/convenzione">
                                                <button type="button" class="btn btn-outline-danger"><i class="fa fa-edit"></i>Richiedi Convenzione
                                                </button>
                                            </a>
                                        </td>
                                    <#else>
                                        <#if EsistePdf>
                                        <td><a href="/account/moduli/convenzione">
                                                <button type="button" class="btn btn-outline-success">
                                                    <i class="fa fa-print"></i>Stampa Modulo
                                                </button>
                                            </a></td>
                                            <#else>
                                                <td><a href="/account/moduli/convenzione">
                                                        <button type="button" class="btn btn-outline-primary">
                                                            <i class="fa fa-print"></i>Modifica Richiesta
                                                        </button>
                                                    </a></td>
                                                <td>
                                                    <form id="form_file_convenzione" action="/account/upload-convenzione" method="post" enctype="multipart/form-data">
                                                        <input type="file" name="filetoupload" size="60"/>
                                                        <input type="submit" form="form_file_convenzione"
                                                                class="btn btn-success pull-left float-sm-left mb-20" value="invia" />
                                                    </form>
                                                </td>
                                        </#if>
                                    </#if>
                                <#else>
                                    <td><a href="/account/moduli/convenzione">
                                            <button type="button" class="btn btn-outline-success"><i class="fa fa-print"></i>Crea
                                                Modulo
                                            </button>
                                        </a></td>
                                </#if>
                            </tr>
                            </tbody>
                        </table>
                    </div>
            </#if>


            <h1 class="mb-0">MODULI TIROCINI SVOLTI</h1>
            <div class="linea-divisione mt-15 mb-30"></div>


                <table class="table table-responsive table-striped table-bordered bg-white table-hover border"
                       id="datatable_2" width="100%"
                       cellspacing="0">
                    <thead>
                    <tr>
                        <th>Titolo Offerta</th>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>E-mail</th>
                        <th>Stato Richiesta</th>
                        <th>Fine Tirocinio</th>
                        <th>Aggiorna Stato</th>
                        <th>Data Creazione</th>
                        <th>Data Aggiornamento</th>
                        <th>Stampa Modulo</th>
                        <th>Carica PDF</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Titolo Offerta</th>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>E-mail</th>
                        <th>Stato Richiesta</th>
                        <th>Fine Tirocinio</th>
                        <th>Aggiorna Stato</th>
                        <th>Data Creazione</th>
                        <th>Data Aggiornamento</th>
                        <th>Stampa Modulo</th>
                        <th>Carica PDF</th>

                    </tr>
                    </tfoot>
                    <tbody>
                    <#list Lista as Lista>
                        <tr>
                            <form id="form_tirocinii_fine_${Lista?index}" action="/account/moduli" method="post">
                            <td><a href="/account/gestione-offerte/view?id=${Lista.offerta.IDOffertaTirocinio}" class="text-blue">${Lista.offerta.titolo}</a></td>
                            <td>${Lista.tirocinante.nome}</td>
                            <td>${Lista.tirocinante.cognome}</td>
                            <td>${Lista.userMail}</td>
                            <#if Lista.tirocinio.stato == 1>
                                <td>Tirocinio in corso</td>
                                <td><input type="checkbox" class="checkboxes"
                                           name="fin_${Lista.tirocinante.nome}-${Lista.tirocinante.cognome}-${Lista.tirocinante.IDTirocinante}-${Lista.tirocinio.IDTirocinio}"
                                           value="1"/> <i
                                            class="fa fa-check" style="color: green;"></i> Tirocinio finito
                                </td>
                            <#elseif Lista.tirocinio.stato == 2>
                                <td>Tirocinio Concluso</td>
                                <td><input type="checkbox" class="checkboxes"
                                           name="fin_${Lista.tirocinante.nome}-${Lista.tirocinante.cognome}-${Lista.tirocinante.IDTirocinante}-${Lista.tirocinio.IDTirocinio}"
                                           value="1" checked
                                           disabled/> <i
                                            class="fa fa-check" style="color: green;"></i> Tirocinio finito
                                </td>
                            </#if>
                                <#if Lista.tirocinio.stato == 1>
                                <td>
                                    <button type="submit" form="form_tirocinii_fine_${Lista?index}"
                                            class="btn btn-success btn-lg pull-right float-sm-left"><i class="fa fa-check"></i> Aggiorna
                                    </button>
                                </td>
                                    <#else>
                                        <td>
                                            <button type="submit" form="form_tirocinii_fine_${Lista?index}"
                                                    class="btn btn-success btn-lg pull-right float-sm-left" disabled><i class="fa fa-check"></i> Aggiorna
                                            </button>
                                        </td>
                                </#if>
                            <td>${Lista.tirocinio.createDate?date?string.short}</td>
                            <td>${Lista.tirocinio.updateDate?date?string.short}</td>

                            <#if Lista.tirocinio.stato == 1>
                                <td>
                                    <button type="button" class="btn btn-outline-danger"><i class="fa fa-print"></i>Non
                                        disponibile
                                    </button>
                                </td>
                            <#elseif Lista.tirocinio.stato == 2>
                                <#if Lista.tirocinio.pdfAzienda??>
                                    <td><a href="/account/moduli/tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa PDF
                                            </button>
                                        </a>
                                    </td>
                                <#else>
                                    <td><a href="/account/moduli/crea-fine-tirocinio?id=${Lista.tirocinio.IDTirocinio}">
                                            <button type="button" class="btn btn-outline-success"><i
                                                        class="fa fa-print"></i>Stampa Modulo
                                            </button>
                                        </a>
                                    </td>
                                </#if>
                            </#if>
                            </form>

                            <#if !Lista.tirocinio.pdfAzienda?? && Lista.tirocinio.stato == 2>
                                <form id="upload_PDFAzineda__${Lista?index}" action="/account/upload-file-tirocinio-azienda" method="post" enctype="multipart/form-data">
                                    <td><input type="file" name="PDFAzienda">
                                        <input type="submit" form="upload_PDFAzineda__${Lista?index}"
                                                class="btn btn-success  mt-10" value="invia"/>
                                        <input type="hidden" name="id" value="${Lista.tirocinio.IDTirocinio}">
                                    </td>
                                </form>
                                <#else>
                                    <td> NON DISPONIBILE
                                    </td>
                            </#if>



                        </tr>
                    </#list>
                    </tbody>
                </table>


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
                "orderable": false
            }, {
                "orderable": false
            }, {
                "orderable": true
            }, {
                "orderable": true
            },{
                "orderable": false
            },{
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