# http://django-marcador.keimlink.de/en/models.html

from __future__ import unicode_literals
from django.db import models
# Create your models here.
from django.contrib.auth.models import User
from django.db import models
from django.utils.encoding import python_2_unicode_compatible
from django.utils.timezone import now

class Tag(models.Model):
    name = models.CharField(max_length=50, unique=True)
    class Meta:
        verbose_name = 'tag'
        verbose_name_plural = 'tags'
        ordering = ['name']
    def __str__(self):
        return self.name

class PublicBookmarkManager(models.Manager):
    def get_queryset(self):
        qs = super(PublicBookmarkManager, self).get_queryset()
        return qs.filter(is_public=True) # filter equals where statement in sql

class Bookmark(models.Model):
    url = models.URLField()
    title = models.CharField('title', max_length=255)
    description = models.TextField('description', blank=True)
    is_public = models.BooleanField('public', default=True)
    date_created = models.DateTimeField('date created', auto_now=True)
    date_updated = models.DateTimeField('date updated', auto_now=True)
    owner = models.ForeignKey(User, verbose_name='owner', related_name='bookmarks')
    tags = models.ManyToManyField(Tag, blank=True)
    objects = models.Manager()
    public = PublicBookmarkManager()

class Meta:
    verbose_name = 'bookmark'
    verbose_name_plural = 'bookmarks'
    ordering = ['-date_created']

def __str__(self):
    return '%s (%s)' % (self.title, self.url)

def save(self, *args, **kwargs):
    if not self.id:
        self.date_created = now()
    self.date_updated = now()
    super(Bookmark, self).save(*args, **kwargs)
