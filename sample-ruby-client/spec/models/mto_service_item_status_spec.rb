=begin
#move.mil API

#The Prime API for move.mil

OpenAPI spec version: 0.0.1
Contact: dp3@truss.works
Generated by: https://github.com/swagger-api/swagger-codegen.git
Swagger Codegen version: 2.4.13

=end

require 'spec_helper'
require 'json'
require 'date'

# Unit tests for SwaggerClient::MTOServiceItemStatus
# Automatically generated by swagger-codegen (github.com/swagger-api/swagger-codegen)
# Please update as you see appropriate
describe 'MTOServiceItemStatus' do
  before do
    # run before each test
    @instance = SwaggerClient::MTOServiceItemStatus.new
  end

  after do
    # run after each test
  end

  describe 'test an instance of MTOServiceItemStatus' do
    it 'should create an instance of MTOServiceItemStatus' do
      expect(@instance).to be_instance_of(SwaggerClient::MTOServiceItemStatus)
    end
  end
end
