package com.github.unhappychoice.kotlinz.data.identity

import com.github.unhappychoice.kotlinz.K1
import com.github.unhappychoice.kotlinz.type.monad.Monad

interface IdentityMonad: Monad<Identity.T>, IdentityApplicative, IdentityFunctor {
  override fun <A> join(v: K1<Identity.T, K1<Identity.T, A>>): Identity<A> {
    return Identity.narrow(Identity.narrow(v).value)
  }

  override fun <A, B> bind(f: (A) -> K1<Identity.T, B>, v: K1<Identity.T, A>): Identity<B> {
    return Identity.narrow(super.bind(f, v))
  }
}
