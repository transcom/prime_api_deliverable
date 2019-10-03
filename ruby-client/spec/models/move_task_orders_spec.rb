=begin
#move.mil Prime API

#The API for move.mil Prime actions.

OpenAPI spec version: 0.1.0

Generated by: https://github.com/swagger-api/swagger-codegen.git
Swagger Codegen version: 2.4.8

=end

require 'spec_helper'
require 'json'
require 'date'

# Unit tests for SwaggerClient::MoveTaskOrders
# Automatically generated by swagger-codegen (github.com/swagger-api/swagger-codegen)
# Please update as you see appropriate
describe 'MoveTaskOrders' do
  before do
    # run before each test
    @instance = SwaggerClient::MoveTaskOrders.new
  end

  after do
    # run after each test
  end

  describe 'test an instance of MoveTaskOrders' do
    it 'should create an instance of MoveTaskOrders' do
      expect(@instance).to be_instance_of(SwaggerClient::MoveTaskOrders)
    end
  end
end
