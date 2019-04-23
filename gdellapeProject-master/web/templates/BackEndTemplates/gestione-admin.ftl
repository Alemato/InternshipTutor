<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Gestione Utenza</title>

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
        <li><a href="/admin/dashboard">HOME DASHBOARD</a></li>
        <li class="active"><a href="#"><b>GESTIONE UTENZA</b></a></li>
    </ol>
    <#include "small-navbar.ftl">

</nav>
<div class="container-fluid">
    <div class="row">
        <#include "sidebar.ftl">
        <#--TODO controlla solo le barre e gli url con il filtro-->
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

            <h2><i class="fa fa-user-md"></i> Utenza di Tipo Amministratore</h2>
            <div class="card mb-50">
                <div class="card-header">
                    <i class="fa fa-table"></i> Amministratori
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered table-hover" id="datatable_amministatori"
                           width="100%"
                           cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nome</th>
                            <th>Cognome</th>

                        </tr>
                        </tfoot>
                        <tbody>
                        <#list listadmin as admin >
                            <tr>

                                <td>${admin.nome}</td>
                                <td>${admin.cognome}</td>

                            </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
            </div>
            <section class="row text-center placeholders pt-10 mb-10">
            </section>
            <#--TODO problema javascrip form-->
            <h3 class="mb-10">Crea Utente Aministratore</h3>
            <form id="form_crea_admin" method="post" action="/admin/crea-admin" class="sky-form">

                <#if ErroreEmail??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreEmail}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em> Indirizzo Email</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="text" <#if ErroreEmail??> class="error" </#if> placeholder="Indirizzo Email"
                           name="Email" <#if ValueOfEmail??>value="${ValueOfEmail}"</#if> required>
                    <b class="tooltip tooltip-bottom-right">Necessario per verificare il tuo account</b>
                </label>


                <#if ErrorePassword??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErrorePassword}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em> Password</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="password" <#if ErrorePassword??> class="error" </#if> placeholder="Password"
                           name="Password" <#if ValueOfPassword??>value="${ValueOfPassword}" </#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>
                <#if ErroreConfermaPassword??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreConfermaPassword}
                    </div>
                </#if>
                <label class="input mb-20">

                    <p><em>*</em> Password</p>
                    <i class="ico-append giu fa fa-lock"></i>
                    <input type="password" <#if ErrorePassword??> class="error" </#if> placeholder="Conferma password"
                           name="ConfermaPassword" <#if ValueOfConfermaPassword??> value="${ValueOfConfermaPassword}" </#if>
                           required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>

                <#if ErroreNome??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreNome}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em> Nome</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="text" <#if ValueofNome??>class="error"</#if> placeholder="Nome"
                           name="Nome" <#if ValueofNome??>value="${ValueofNome}"  </#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>
                <#if ErroreCognome??>
                    <div class="alert alert-danger mb-20">
                        <button type="button" class="close" data-dismiss="alert">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Chiudi</span>
                        </button>
                        <strong>Attenzione!</strong> ${ErroreCognome}
                    </div>
                </#if>
                <label class="input">
                    <p><em>*</em>Cognome</p>
                    <i class="ico-append giu fa fa-envelope"></i>
                    <input type="text" <#if ValueOfCognome??>class="error"</#if> placeholder="Cognome"
                           name="Cognome" <#if ValueOfCognome??> value="${ValueOfCognome}"</#if> required>
                    <b class="tooltip tooltip-bottom-right">Solo caratteri e numeri latini, necessario per l&apos;accesso
                        al tuo account</b>
                </label>

                <footer class="text-center text-sm-right mt-25 ">
                    <button type="submit" form="form_crea_admin"
                            class="btn btn-success btn-lg pull-right float-sm-right mb-20"><i
                                class="fa fa-check"></i> Crea
                    </button>
                    <button type="reset" form="form_crea_admin"
                            class="btn btn-red btn-lg pull-right float-sm-left mb-20"><i
                                class="fa fa-times"></i> Annulla
                    </button>
                </footer>
            </form>
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


    function initTableAdmin() {

        var table = jQuery('#datatable_amministatori');

        var oTable = table.dataTable({
            "columns": [{
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
                "searchable": true,
                "targets": [0]
            }],
        });

        var oTableColReorder = new $.fn.dataTable.ColReorder(oTable);

        var tableWrapper = jQuery('#datatable_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown
    }

    initTableAdmin();

</script>

</body>
</html>
