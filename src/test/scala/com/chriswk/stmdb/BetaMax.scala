package com.chriswk.stmdb

import co.freeside.betamax.proxy.jetty.ProxyServer
import co.freeside.betamax.{Recorder, TapeMode}
import org.specs2.execute.AsResult
import org.specs2.mutable.Around

class BetaMax(tape: String, mode: Option[TapeMode] = None) extends Around {
  def around[T: AsResult](t: => T) = BetaMax.around(t, tape, mode)
}

object BetaMax {
  def apply(tape: String, mode: Option[TapeMode] = None) = new BetaMax(tape, mode)

  def around[T: AsResult](t: => T, tape: String, mode: Option[TapeMode]) = {
    synchronized {
      val recorder = new Recorder
      val proxyServer = new ProxyServer(recorder)
      recorder.insertTape(tape)
      recorder.getTape.setMode(mode getOrElse recorder.getDefaultMode())
      proxyServer.start()
      try {
        AsResult(t)
      } finally {
        recorder.ejectTape()
        proxyServer.stop()
      }
    }
  }
}