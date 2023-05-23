package com.example.domain;

import com.google.protobuf.Empty;
import com.example.CounterApi;
import kalix.javasdk.valueentity.ValueEntity;
import kalix.javasdk.valueentity.ValueEntityContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Value Entity Service described in your io/kx/loanapp/counter_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class Counter extends AbstractCounter {
  @SuppressWarnings("unused")
  private final String entityId;

  public Counter(ValueEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public CounterDomain.CounterState emptyState() {
    return CounterDomain.CounterState.getDefaultInstance();
  }

  @Override
  public ValueEntity.Effect<Empty> increase(CounterDomain.CounterState currentState, CounterApi.IncreaseValue increaseValue) {
    CounterDomain.CounterState newState = currentState.toBuilder()
            .setValue(currentState.getValue() + increaseValue.getValue())
            .setStatus(CounterDomain.CounterStatus.STARTED)
            .build();
    return effects().updateState(newState).thenReply(Empty.getDefaultInstance());
  }

  @Override
  public ValueEntity.Effect<Empty> decrease(CounterDomain.CounterState currentState, CounterApi.DecreaseValue decreaseValue) {
    CounterDomain.CounterState newState = currentState.toBuilder()
            .setValue(currentState.getValue() - decreaseValue.getValue())
            .setStatus(CounterDomain.CounterStatus.PAUSED)
            .build();
    return effects().updateState(newState).thenReply(Empty.getDefaultInstance());
  }

  @Override
  public ValueEntity.Effect<Empty> reset(CounterDomain.CounterState currentState, CounterApi.ResetValue resetValue) {
    CounterDomain.CounterState newState = currentState.toBuilder()
            .setValue(0)
            .setStatus(CounterDomain.CounterStatus.STOPPED)
            .build();
    return effects().updateState(newState).thenReply(Empty.getDefaultInstance());
  }

  @Override
  public ValueEntity.Effect<CounterApi.CurrentCounter> getCurrentCounter(CounterDomain.CounterState currentState, CounterApi.GetCounter getCounter) {
    CounterApi.CurrentCounter counter = CounterApi.CurrentCounter.newBuilder()
            .setValue(currentState.getValue())
            .setStatus(CounterApi.CounterApiStatus.forNumber(currentState.getStatusValue()))
            .build();
    return effects().reply(counter);
  }
}
