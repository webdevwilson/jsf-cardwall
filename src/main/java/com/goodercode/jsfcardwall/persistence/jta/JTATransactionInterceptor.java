package com.goodercode.jsfcardwall.persistence.jta;

import com.goodercode.jsfcardwall.persistence.Transactional;
import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

@Interceptor
@Transactional
public class JTATransactionInterceptor {

    @Resource
    private UserTransaction utx;

    @AroundInvoke
    public Object wrapTransaction(final InvocationContext ic) throws Exception {

        boolean startedTransaction = false;
        if (utx.getStatus() != Status.STATUS_ACTIVE) {
            utx.begin();
            startedTransaction = true;
        }

        Object ret = null;
        try {
            ret = ic.proceed();
            if (startedTransaction) {
                utx.commit();
            }
        } catch (final Exception e) {
            if (startedTransaction) {
                utx.rollback();
            }
            throw e;
        }

        return ret;
    }
}
