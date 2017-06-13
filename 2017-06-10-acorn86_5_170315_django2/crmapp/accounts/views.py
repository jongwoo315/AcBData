# -*-encoding:utf-8-*-
from django.views.generic import ListView
from django.contrib.auth.decorators import login_required
from django.utils.decorators import method_decorator
from .models import Account
from django.http import HttpResponseForbidden
from django.shortcuts import render


# 1. 데이터베이스에서의 쿼리를 통해 계정에 해당하는 모든 유저를 가져온다
# 2. 한 페이지에 12개만 출력되도록 할 것
# 3. 자신의 계정을 검색할 수 있도록 할 것
class AccountList(ListView):
    # Account model을 사용한다(models.py)
    model = Account
    # 페이지당 12개표시
    paginate_by = 12
    # account list를 보여주기 위해 사용
    template_name = 'accounts/account_list.html'
    # 나중에 html에서 사용할 이름 => 'accounts'
    context_object_name = 'accounts'

    # update queryset to account for a possible user search query
    def get_queryset(self):
        try:  # 사용자가 search를 하는지 체크한다 / 한다면 쿼리를 a에 할당
            a = self.request.GET.get('account',)
        except KeyError:  # 쿼리를 하는게 아니라면 a에는 None이 들어감
            a = None

        if a:  # a에 값이 들어 있다면, account를 그 값에 따라 필터링해라
            account_list = Account.objects.filter(name__icontains=a, owner=self.request.user)
        else:  # 값이 없는 경우 - 유저에 대한 계정들만 표시
            account_list = Account.objects.filter(owner=self.request.user)
        return account_list

    # 보안 설정. 인증된 사용자만 뷰를 볼 수 있도록 하는 것 (login_required가 그 역할을 함)
    @method_decorator(login_required)
    def dispatch(self, *args, **kwargs):
        return super(AccountList, self).dispatch(*args, **kwargs)

    @login_required
    def account_detail(request, uuid):
        account = Account.objects.get(uuid=uuid)
        if account.owner != request.user:
            return HttpResponseForbidden()

        variables = {
            'account':account,
        }
        return render(request, 'accounts/account_detail.html', variables)
