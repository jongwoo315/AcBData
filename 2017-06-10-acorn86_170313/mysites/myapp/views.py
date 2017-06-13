from django.shortcuts import render
from django.shortcuts import render_to_response

from django.template import RequestContext
from django.http import HttpResponseRedirect
from django.core.urlresolvers import reverse
from myapp.models import Document
from myapp.forms import DocumentForm

def list(request):
    if request.method == 'POST':
        form = DocumentForm(request.POST, request.FILES)
        if form.is_valid():
            newdoc = Document(docfile=request.FILES['docfile'])
            newdoc.save()
            return HttpResponseRedirect(reverse('list'))
            #return HttpResponseRedirect(reverse('list'))
            #return HttpResponseRedirect(reverse('list:list'))
    else:
        form = DocumentForm()
        documents = Document.objects.all()
        #return render_to_response('list.html', {'documents':documents, 'form':form}, context_instance=RequestContext(request
        #return render('list.html', {'documents':documents, 'form':form}, context=RequestContext(request))
        return render(request, 'myapp/list.html', {'documents':documents, 'form':form})


# Create your views here.
