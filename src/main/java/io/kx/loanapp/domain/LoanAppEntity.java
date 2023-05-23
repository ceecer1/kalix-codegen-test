package io.kx.loanapp.domain;

import com.google.protobuf.Empty;
import io.kx.loanapp.api.LoanAppApi;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity;
import kalix.javasdk.eventsourcedentity.EventSourcedEntity.Effect;
import kalix.javasdk.eventsourcedentity.EventSourcedEntityContext;

// This class was initially generated based on the .proto definition by Kalix tooling.
// This is the implementation for the Event Sourced Entity Service described in your io/kx/loanapp/api/loan_app_api.proto file.
//
// As long as this file exists it will not be overwritten: you can maintain it yourself,
// or delete it so it is regenerated as needed.

public class LoanAppEntity extends AbstractLoanAppEntity {

  @SuppressWarnings("unused")
  private final String entityId;

  public LoanAppEntity(EventSourcedEntityContext context) {
    this.entityId = context.entityId();
  }

  @Override
  public LoanAppDomain.LoanAppDomainState emptyState() {
    throw new UnsupportedOperationException("Not implemented yet, replace with your empty entity state");
  }

  @Override
  public Effect<Empty> submit(LoanAppDomain.LoanAppDomainState currentState, LoanAppApi.SubmitCommand submitCommand) {
    return effects().error("The command handler for `Submit` is not implemented, yet");
  }

  @Override
  public Effect<LoanAppApi.LoanAppState> get(LoanAppDomain.LoanAppDomainState currentState, LoanAppApi.GetCommand getCommand) {
    return effects().error("The command handler for `Get` is not implemented, yet");
  }

  @Override
  public Effect<Empty> approve(LoanAppDomain.LoanAppDomainState currentState, LoanAppApi.ApproveCommand approveCommand) {
    return effects().error("The command handler for `Approve` is not implemented, yet");
  }

  @Override
  public Effect<Empty> decline(LoanAppDomain.LoanAppDomainState currentState, LoanAppApi.DeclineCommand declineCommand) {
    return effects().error("The command handler for `Decline` is not implemented, yet");
  }

  @Override
  public LoanAppDomain.LoanAppDomainState submitted(LoanAppDomain.LoanAppDomainState currentState, LoanAppDomain.Submitted submitted) {
    throw new RuntimeException("The event handler for `Submitted` is not implemented, yet");
  }
  @Override
  public LoanAppDomain.LoanAppDomainState approved(LoanAppDomain.LoanAppDomainState currentState, LoanAppDomain.Approved approved) {
    throw new RuntimeException("The event handler for `Approved` is not implemented, yet");
  }
  @Override
  public LoanAppDomain.LoanAppDomainState declined(LoanAppDomain.LoanAppDomainState currentState, LoanAppDomain.Declined declined) {
    throw new RuntimeException("The event handler for `Declined` is not implemented, yet");
  }

}
