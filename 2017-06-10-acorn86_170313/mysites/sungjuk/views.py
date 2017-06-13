from django.shortcuts import render
from django.http import HttpResponse
from django.views.generic import TemplateView, ListView
from django.views.generic import DetailView
from django.views.generic.edit import CreateView, UpdateView, DeleteView
from django.core.urlresolvers import reverse_lazy
from .models import Sungjuk
import csv
from .resources import SungjukResource


class SungjukList(ListView):
    model = Sungjuk


class SungjukCreate(CreateView):
    model = Sungjuk
    success_url = reverse_lazy('sungjuk:sungjuk_list')
    fields = ['name', 'kor', 'mat', 'eng']


class SungjukUpdate(UpdateView):
    model = Sungjuk
    success_url = reverse_lazy('sungjuk:sungjuk_list')
    fields = ['name', 'kor', 'mat', 'eng']


class SungjukDelete(DeleteView):
    model = Sungjuk
    success_url = reverse_lazy('sungjuk:sungjuk_list')


def export_csv_book(request):
    sungjuk_resource = SungjukResource()
    dataset = sungjuk_resource.export()
    response = HttpResponse(dataset.csv, content_type='text/csv')
    response['Content-Disposition'] = 'attachment; filename="sungjuk.csv"'
    return response


def export_excel_book(request):
    sungjuk_resource = SungjukResource()
    dataset = sungjuk_resource.export()
    response = HttpResponse(dataset.xls, content_type='application/vnd.ms-excel')
    response['Content-Disposition'] = 'attachment; filename="Sungjuk.xls"'
    return response


def simple_upload(request):
    if request.method == 'POST':
        sungjuk_resource = SungjukResource()
        dataset = Dataset()
        new_sungjuks = request.FILES['myfile']
        imported_data = dataset.load(new_sungjuks.read())
        result = sungjuk_resource.import_data(dataset, dry_run=True)
        if not result.has_errors():
            sungjuk_resource.import_data(dataset, dry_run=False)
    return render(request, 'sungjuk/simple_upload.html')
